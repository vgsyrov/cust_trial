package com.cust_trial.journal.resultscontrolapigateway.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LessionJson {
    @JsonProperty("personId")
    private String personId;

    @JsonProperty("lessionName")
    private String lessionName;

    @JsonCreator
    public LessionJson(
            @JsonProperty("personId") String personId,
            @JsonProperty("lessionName") String lessionName) {
        this.personId = personId;
        this.lessionName = lessionName;
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
}
