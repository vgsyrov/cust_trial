package com.cust_trial.journal.schedulecalendar;

import java.io.Serializable;

public class EventAttendanceFactMessage implements Serializable {

    public EventAttendanceFactMessage(String eventId, String personId, String attendanceFact) {
        this.eventId = eventId;
        this.personId = personId;
        this.attendanceFact = attendanceFact;
    }

    private String eventId;

    private String personId;

    private String attendanceFact;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAttendanceFact() {
        return attendanceFact;
    }

    public void setAttendanceFact(String attendanceFact) {
        this.attendanceFact = attendanceFact;
    }
}
