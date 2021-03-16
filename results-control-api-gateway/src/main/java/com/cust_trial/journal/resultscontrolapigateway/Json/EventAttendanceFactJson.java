package com.cust_trial.journal.resultscontrolapigateway.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventAttendanceFactJson {
    @JsonProperty("eventId")
    private String eventId;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("attendanceFact")
    private String attendanceFact;

    @JsonCreator
    public EventAttendanceFactJson(
            @JsonProperty("eventId") String eventId,
            @JsonProperty("personId") String personId,
            @JsonProperty("attendanceFact") String attendanceFact
    ) {
        this.personId = personId;
        this.eventId = eventId;
        this.attendanceFact = attendanceFact;
    }

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
