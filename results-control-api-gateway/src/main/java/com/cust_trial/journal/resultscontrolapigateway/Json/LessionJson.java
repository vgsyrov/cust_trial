package com.cust_trial.journal.resultscontrolapigateway.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LessionJson {
    @JsonProperty("lessionId")
    private String lessionId;

    @JsonProperty("lessionName")
    private String lessionName;

    @JsonCreator
    public LessionJson(
            @JsonProperty("lessionId") String lessionId,
            @JsonProperty("lessionName") String lessionName) {
        this.lessionId = lessionId;
        this.lessionName = lessionName;
    }

    public String getLessionId() {
        return lessionId;
    }

    public void setLessionId(String lessionId) {
        this.lessionId = lessionId;
    }

    public String getLessionName() {
        return lessionName;
    }

    public void setLessionName(String lessionName) {
        this.lessionName = lessionName;
    }
}
