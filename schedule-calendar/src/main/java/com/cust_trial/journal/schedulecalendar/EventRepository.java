package com.cust_trial.journal.schedulecalendar;

import com.cust_trial.journal.schedulecalendar.Entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

    Event findEventByEventId(String id);

    Iterable<Event> findEventByLessionId(String id);

    Iterable<Event> findAll();
}
