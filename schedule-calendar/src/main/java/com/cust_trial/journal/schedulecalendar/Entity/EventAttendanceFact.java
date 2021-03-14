package com.cust_trial.journal.schedulecalendar.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTATTENDANCEFACT")
public class EventAttendanceFact {

    @Id
    @Column(name = "EVENTID", nullable = false)
    private String eventId;

    @Column(name = "PERSONID", nullable = false)
    private String personId;
}
