package com.cust_trial.journal.schedulecalendar;

import com.cust_trial.journal.schedulecalendar.Entity.EventAttendanceFact;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventAttendanceFactController {

    @Autowired
    RabbitTemplate template;

    @Value("${sc.attendance.queue.name}")
    private String QUEUE_NAME;

    @Autowired
    private EventAttendanceFactRepository eventAttendanceFactRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/list_ea")
    public Iterable<EventAttendanceFact> getEventAttendanceFactList(){
        return eventAttendanceFactRepository.findAll();
    }


    @RequestMapping(method={RequestMethod.POST,RequestMethod.PUT},
        path="/auto-attendance",
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public void autoAttendance(@RequestBody AutoAttendanceBody body) {

        EventAttendanceFact ea = eventAttendanceFactRepository
                .findEventAttendanceFactByEventIdAndPersonId(
                        body.getEventId(),
                        body.getPersonId()
                );

        if(ea == null){
            EventAttendanceFact eventAttendanceFact = new EventAttendanceFact();
            eventAttendanceFact.setEventId(body.getEventId());
            eventAttendanceFact.setPersonId(body.getPersonId());
            eventAttendanceFact.setAttendanceFact(body.getAttendanceFact());
            eventAttendanceFactRepository.save(eventAttendanceFact);
        } else {
            ea.setAttendanceFact(body.getAttendanceFact());
            eventAttendanceFactRepository.save(ea);
        }

        try {
            String lessonId = eventRepository.findEventByEventId(body.getEventId()).getLessionId();

            template.convertAndSend(QUEUE_NAME, new EventAttendanceFactMessage(
                    lessonId,
                    body.getPersonId(),
                    body.getAttendanceFact()));

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
