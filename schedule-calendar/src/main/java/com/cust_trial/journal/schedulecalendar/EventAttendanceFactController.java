package com.cust_trial.journal.schedulecalendar;

import com.cust_trial.journal.schedulecalendar.Entity.EventAttendanceFact;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventAttendanceFactController {

    @Autowired
    RabbitTemplate template;

    @Value("${sc.attendance.queue.name}")
    private String QUEUE_NAME;

    @Autowired
    private EventAttendanceFactRepository eventAttendanceFactRepository;

    @GetMapping("/list_ea")
    public Iterable<EventAttendanceFact> getEventAttendanceFactList(){
        return eventAttendanceFactRepository.findAll();
    }

    @GetMapping("/findByEventId/{id}")
    public EventAttendanceFact getById(@PathVariable String id){
        return eventAttendanceFactRepository.findEventAttendanceFactByEventId(id);
    }

    @GetMapping("/listByPersonId/{id}")
    public Iterable<EventAttendanceFact> getListByPersonId(@PathVariable String id){
        return eventAttendanceFactRepository.findEventAttendanceFactsByPersonId(id);
    }

    @PutMapping("/auto-attendance/{eventId}/{personId}/{attendanceFact}")
    public void autoAttendance(@PathVariable String eventId,
                               @PathVariable String personId,
                               @PathVariable String attendanceFact){
        EventAttendanceFact eventAttendanceFact = new EventAttendanceFact();
        eventAttendanceFact.setEventId(eventId);
        eventAttendanceFact.setPersonId(personId);
        eventAttendanceFact.setAttendanceFact(attendanceFact);
        eventAttendanceFactRepository.save(eventAttendanceFact);



        template.convertAndSend(QUEUE_NAME, new EventAttendanceFactMessage(eventId, personId, attendanceFact));
        System.out.println("send message to "+QUEUE_NAME);
    }
}
