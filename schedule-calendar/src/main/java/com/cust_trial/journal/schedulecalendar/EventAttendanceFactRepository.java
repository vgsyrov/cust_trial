package com.cust_trial.journal.schedulecalendar;

import com.cust_trial.journal.schedulecalendar.Entity.EventAttendanceFact;
import org.springframework.data.repository.CrudRepository;

public interface EventAttendanceFactRepository extends CrudRepository<EventAttendanceFact, String> {

    Iterable<EventAttendanceFact> findAll();

    EventAttendanceFact findEventAttendanceFactByEventId(String id);

    Iterable<EventAttendanceFact> findEventAttendanceFactsByPersonId(String id);

}
