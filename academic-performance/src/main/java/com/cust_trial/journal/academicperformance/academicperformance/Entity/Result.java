package com.cust_trial.journal.academicperformance.academicperformance.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(ResultId.class)
@Table(name = "RESULT")
public class Result implements Serializable {

    public Result() {}

    @javax.persistence.Id
    @Column(name = "LESSIONID", nullable = false)
    private String lessionId;

    @javax.persistence.Id
    @Column(name = "PERSONID", nullable = false)
    private String personId;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "CREATEDAT", nullable = false)
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESULTTYPE", length = 20, nullable = false)
    private ResultType resultType;

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

    public void setCreatedAt(Date createdAd) {
        this.createdAt = createdAd;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Result{" +
                "lessionId='" + lessionId + '\'' +
                ", personId='" + personId + '\'' +
                ", value='" + value + '\'' +
                ", createdAd=" + createdAt +
                ", resultType=" + resultType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return lessionId.equals(result.lessionId) && personId.equals(result.personId) && Objects.equals(value, result.value) && createdAt.equals(result.createdAt) && resultType == result.resultType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessionId, personId, value, createdAt, resultType);
    }
}
