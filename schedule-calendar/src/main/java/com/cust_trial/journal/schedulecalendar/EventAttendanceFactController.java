package com.cust_trial.journal.schedulecalendar;

import com.cust_trial.journal.schedulecalendar.Entity.EventAttendanceFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class EventAttendanceFactController {

    @Autowired
    private EventAttendanceFactRepository eventAttendanceFactRepository;

    @GetMapping("/list_ea")
    public Iterable<EventAttendanceFact> getEventAttendanceFactList(){
        return eventAttendanceFactRepository.findAll();
    }

    @GetMapping("/findByEventId")
    public EventAttendanceFact getById(@PathVariable String id){
        return eventAttendanceFactRepository.findEventAttendanceFactByEventId(id);
    }

    @GetMapping("/listByPersonId")
    public Iterable<EventAttendanceFact> getListByPersonId(@PathVariable String id){
        return eventAttendanceFactRepository.findEventAttendanceFactsByPersonId(id);
    }
}
