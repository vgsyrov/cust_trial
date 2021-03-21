package com.cust_trial.journal.schedulecalendar.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(EventAttendanceFactId.class)
@Table(name = "EVENTATTENDANCEFACT")
public class EventAttendanceFact {

    @Id
    @Column(name = "EVENTID", nullable = false)
    private String eventId;

    @Id
    @Column(name = "PERSONID", nullable = false)
    private String personId;

    @Id
    @Column(name = "ATTENDANCEFACT")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventAttendanceFact that = (EventAttendanceFact) o;
        return eventId.equals(that.eventId) && personId.equals(that.personId) && Objects.equals(attendanceFact, that.attendanceFact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, personId, attendanceFact);
    }
}
