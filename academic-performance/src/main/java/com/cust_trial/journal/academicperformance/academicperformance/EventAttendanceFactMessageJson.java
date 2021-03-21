package com.cust_trial.journal.academicperformance.academicperformance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class EventAttendanceFactMessageJson implements Serializable {

    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("attendanceFact")
    private String attendanceFact;

    @JsonCreator
    public EventAttendanceFactMessageJson(
            @JsonProperty("lessonId") String lessonId,
            @JsonProperty("personId") String personId,
            @JsonProperty("attendanceFact") String attendanceFact
    ) {
        this.lessonId = lessonId;
        this.personId = personId;
        this.attendanceFact = attendanceFact;

    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAttendanceFact() {
        return attendanceFact;
    }

    public void setAttendanceFact(String attendanceFact) {
        this.attendanceFact = attendanceFact;
    }

    @Override
    public String toString() {
        return "EventAttendanceFactMessageJson{" +
                "lessonId='" + lessonId + '\'' +
                ", personId='" + personId + '\'' +
                ", attendanceFact='" + attendanceFact + '\'' +
                '}';
    }
}
