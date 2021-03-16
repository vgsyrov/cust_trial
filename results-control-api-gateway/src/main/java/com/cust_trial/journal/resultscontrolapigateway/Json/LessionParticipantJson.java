package com.cust_trial.journal.resultscontrolapigateway.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LessionParticipantJson {
    @JsonProperty("lessionId")
    private String lessionId;

    @JsonProperty("personId")
    private String personId;

    private String lessionName;

    private String personName;

    @JsonCreator
    public LessionParticipantJson(
            @JsonProperty("lessionId") String lessionId,
            @JsonProperty("personId") String personId) {
        this.lessionId = lessionId;
        this.personId = personId;

    }

    public String getLessionId() {
        return lessionId;
    }

    public void setLessionId(String lessionId) {
        this.lessionId = lessionId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getLessionName() {
        return lessionName;
    }

    public void setLessionName(String lessionName) {
        this.lessionName = lessionName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
