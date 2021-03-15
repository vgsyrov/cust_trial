package com.cust_trial.journal.periodplanning.Entity;

import java.io.Serializable;
import java.util.Objects;

public class LessionPartisipantId implements Serializable {
    protected String lessionId;
    protected String personId;

    public LessionPartisipantId() {
    }

    public LessionPartisipantId(String lessionId, String personId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessionPartisipantId that = (LessionPartisipantId) o;
        return lessionId.equals(that.lessionId) && personId.equals(that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessionId, personId);
    }
}
