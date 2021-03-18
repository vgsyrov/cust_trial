package com.cust_trial.journal.resultscontrolapigateway.controller;

import com.cust_trial.journal.resultscontrolapigateway.Json.LessionJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.LessionParticipantJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.PersonJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.ResultJson;
import com.cust_trial.journal.resultscontrolapigateway.client.AcademicPerformanceClient;
import com.cust_trial.journal.resultscontrolapigateway.client.PeriodPlaningClient;
import com.cust_trial.journal.resultscontrolapigateway.client.PersonalInfoClient;
import com.cust_trial.journal.resultscontrolapigateway.client.ScheduleCalendarClient;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
//@Tag(name="Название контроллера", description="Описание контролера")
public class ApiGatewayController {

    @Autowired
    PersonalInfoClient personalInfoClient;

    @Autowired
    PeriodPlaningClient periodPlaningClient;

    @Autowired
    AcademicPerformanceClient academicPerformanceClient;

    @Autowired
    ScheduleCalendarClient scheduleCalendarClient;

    @PutMapping("/auto-attendance/{eventId}/{personId}/{attendanceFact}")
    public void autoAttendance(@PathVariable String eventId,
                               @PathVariable String personId,
                               @PathVariable String attendanceFact){
        scheduleCalendarClient.autoAttendance(eventId, personId, attendanceFact);
    }


    @GetMapping("/eventResults/{id}")
    public Observable<List<ResultJson>> getEventResults(@PathVariable String id) {
        Observable<List<PersonJson>> persons = Observable.just(personalInfoClient.getPersonalInfoNB());
        Observable<List<LessionJson>> lessions = Observable.just(periodPlaningClient.getLessionList());
        Observable<List<ResultJson>> results = Observable.just(academicPerformanceClient.findResultByLessionId(id));

        return Observable.zip(persons, lessions, results,
                (List<PersonJson> personJsonList,
                 List<LessionJson> lessionJsonList,
                 List<ResultJson> resultJsonList)
                        -> combineEventResults(personJsonList, lessionJsonList, resultJsonList))
                .cache();
    }



    private List<ResultJson> combineEventResults(List<PersonJson> personJsons,
                                                 List<LessionJson> lessions,
                                                 List<ResultJson> results){
        Map<String, PersonJson> personMap = new HashMap<>(personJsons.size());
        Map<String, LessionJson> lessionMap = new HashMap<>(lessions.size());

        personJsons.forEach(item -> personMap.put(item.getPersonId(), item));
        lessions.forEach(item -> lessionMap.put(item.getLessionId(), item));

        results
                .stream()
                .peek(item -> item.setPersonName(personMap.get(item.getPersonId()).getFullName()))
                .forEach(item -> item.setLessionName(lessionMap.get(item.getLessionId()).getLessionName()));

        return results;

    }

}
