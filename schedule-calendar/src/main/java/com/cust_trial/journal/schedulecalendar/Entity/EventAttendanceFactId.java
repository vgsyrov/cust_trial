package com.cust_trial.journal.schedulecalendar.Entity;

import java.io.Serializable;

public class EventAttendanceFactId implements Serializable {

    private String eventId;

    private String personId;


    public EventAttendanceFactId() {
    }

    public EventAttendanceFactId(String eventId, String personId) {
        this.eventId = eventId;
        this.personId = personId;
    }
}
