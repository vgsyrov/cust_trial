package com.cust_trial.journal.academicperformance.academicperformance.Entity;

import java.io.Serializable;
import java.util.Objects;

public class ResultId implements Serializable {
    protected String lessionId;
    protected String personId;
    protected ResultType resultType;

    public ResultId() {
    }

    public ResultId(String lessionId, String personId, ResultType resultType) {
        this.lessionId = lessionId;
        this.personId = personId;
        this.resultType = resultType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultId resultId = (ResultId) o;
        return lessionId.equals(resultId.lessionId) && personId.equals(resultId.personId) && resultType == resultId.resultType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessionId, personId, resultType);
    }
}
