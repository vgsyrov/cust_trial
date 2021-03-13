package com.cust_trial.journal.personalinfosvc.personalinformation.Entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @Column(name = "PERSONID")
    private String personId;

    @Column(name = "FULLNAME")
    private String fullName;

    public Person() { }

    public Person(String personId, String fullName) {
        this.personId = personId;
        this.fullName = fullName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
