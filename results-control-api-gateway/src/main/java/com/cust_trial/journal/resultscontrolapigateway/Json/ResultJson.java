package com.cust_trial.journal.resultscontrolapigateway.Json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ResultJson {

    @ApiModelProperty(
            value = "ID урока",
            name = "ID урока",
            dataType = "String",
            example = "initialLesson_1")
    @JsonProperty("lessionId")
    private String lessionId;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("value")
    private String value;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("resultType")
    private String resultType;

    private String lessionName;

    private String personName;


    @JsonCreator
    public ResultJson(
            @JsonProperty("lessionId") String lessionId,
            @JsonProperty("personId") String personId,
            @JsonProperty("value") String value,
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("resultType") String resultType
    ) {
        this.personId = personId;
        this.lessionId = lessionId;
        this.value = value;
        this.createdAt = createdAt;
        this.resultType = resultType;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
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
