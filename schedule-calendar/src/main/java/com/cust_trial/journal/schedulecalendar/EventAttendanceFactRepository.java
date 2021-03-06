package com.cust_trial.journal.schedulecalendar;

import com.cust_trial.journal.schedulecalendar.Entity.EventAttendanceFact;
import com.cust_trial.journal.schedulecalendar.Entity.EventAttendanceFactId;
import org.springframework.data.repository.CrudRepository;

public interface EventAttendanceFactRepository extends CrudRepository<EventAttendanceFact, EventAttendanceFactId> {

    Iterable<EventAttendanceFact> findAll();

    EventAttendanceFact findEventAttendanceFactByEventIdAndPersonId(String eventId, String personId);

}
