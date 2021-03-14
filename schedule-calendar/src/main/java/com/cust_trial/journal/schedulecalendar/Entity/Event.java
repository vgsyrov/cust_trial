package com.cust_trial.journal.schedulecalendar.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EVENT")
public class Event {

    @Id
    @Column(name = "EVENTID", nullable = false)
    private String eventId;

    @Column(name = "LESSIONID", nullable = false)
    private String lessionId;

    @Column(name = "STARTAT", nullable = false)
    private Date startAt;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getLessionId() {
        return lessionId;
    }

    public void setLessionId(String lessionId) {
        this.lessionId = lessionId;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId.equals(event.eventId) && lessionId.equals(event.lessionId) && startAt.equals(event.startAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, lessionId, startAt);
    }
}
