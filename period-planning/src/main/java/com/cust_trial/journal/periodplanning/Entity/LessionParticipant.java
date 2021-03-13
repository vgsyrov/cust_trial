package com.cust_trial.journal.periodplanning.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "LESSIONPARTICIPANT")
public class LessionParticipant {

    @Id
    @Column(name = "LESSIONID", nullable = false)
    private String lessionId;

    @Column(name = "PERSONID", nullable = false)
    private String personId;

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
        LessionParticipant that = (LessionParticipant) o;
        return lessionId.equals(that.lessionId) && personId.equals(that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessionId, personId);
    }

    @Override
    public String toString() {
        return "LessionParticipant{" +
                "lessionId='" + lessionId + '\'' +
                ", personId='" + personId + '\'' +
                '}';
    }
}
