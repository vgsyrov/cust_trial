package com.cust_trial.journal.resultscontrolapigateway.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class EventJson {

    @JsonProperty("eventId")
    private String eventId;

    @JsonProperty("lessionId")
    private String lessionId;

    @JsonProperty("startAt")
    private Date startAt;

    @JsonCreator
    public EventJson(
            @JsonProperty("eventId") String eventId,
            @JsonProperty("lessionId") String lessionId,
            @JsonProperty("startAt") Date startAt
    ) {
        this.eventId = eventId;
        this.lessionId = lessionId;
        this.startAt = startAt;
    }

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
}
