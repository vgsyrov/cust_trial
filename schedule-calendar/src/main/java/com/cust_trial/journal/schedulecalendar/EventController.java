package com.cust_trial.journal.schedulecalendar;

import com.cust_trial.journal.schedulecalendar.Entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/list")
    public Iterable<Event> getEventsList(){
        return eventRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Event getEventById(@PathVariable String id){
        return eventRepository.findEventByEventId(id);
    }

    @GetMapping("/findByLessionId/{id}")
    public Iterable<Event> getEventsByLessionId(@PathVariable String id){
        return eventRepository.findEventByLessionId(id);
    }
}
