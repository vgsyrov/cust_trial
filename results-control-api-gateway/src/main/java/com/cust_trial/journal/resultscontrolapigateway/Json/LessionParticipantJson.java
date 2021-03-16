package com.cust_trial.journal.resultscontrolapigateway.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LessionParticipantJson {
    @JsonProperty("lessionId")
    private String lessionId;

    @JsonProperty("personId")
    private String personId;

    @JsonCreator
    public LessionParticipantJson(
            @JsonProperty("lessionId") String lessionId,
            @JsonProperty("personId") String personId) {
        this.lessionId = lessionId;
        this.personId = personId;

    }

}
