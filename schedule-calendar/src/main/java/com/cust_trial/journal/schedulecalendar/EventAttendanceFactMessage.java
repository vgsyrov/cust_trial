package com.cust_trial.journal.schedulecalendar;

import java.io.Serializable;

public class EventAttendanceFactMessage implements Serializable {

    public EventAttendanceFactMessage(String lessonId, String personId, String attendanceFact) {
        this.lessonId = lessonId;
        this.personId = personId;
        this.attendanceFact = attendanceFact;
    }

    private String lessonId;

    private String personId;

    private String attendanceFact;

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
}
