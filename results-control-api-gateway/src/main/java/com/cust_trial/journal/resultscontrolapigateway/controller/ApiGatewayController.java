package com.cust_trial.journal.resultscontrolapigateway.controller;

import com.cust_trial.journal.resultscontrolapigateway.Json.*;
import com.cust_trial.journal.resultscontrolapigateway.client.AcademicPerformanceClient;
import com.cust_trial.journal.resultscontrolapigateway.client.PeriodPlaningClient;
import com.cust_trial.journal.resultscontrolapigateway.client.PersonalInfoClient;
import com.cust_trial.journal.resultscontrolapigateway.client.ScheduleCalendarClient;
import io.reactivex.Observable;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.cust_trial.journal.resultscontrolapigateway.AttendanceFactMapper;

import java.util.*;


@RestController
public class ApiGatewayController {

    @Autowired
    PersonalInfoClient personalInfoClient;

    @Autowired
    PeriodPlaningClient periodPlaningClient;

    @Autowired
    AcademicPerformanceClient academicPerformanceClient;

    @Autowired
    ScheduleCalendarClient scheduleCalendarClient;



    @ApiOperation(value = "Установка посещения студентом занятия (снятие отметки)",
            notes = "Для установки признака посещения параметр attendanceFact равным П - или Н - для прогула модели ResultJson")
    @RequestMapping(method={RequestMethod.POST,RequestMethod.PUT},
            path="/auto-attendance",
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public void autoAttendance(@RequestBody AutoAttendanceRequestBodyJson body) {
        String mappedAttendance = mapAttendanceFactValue(body.getAttendanceFact());
        if(mappedAttendance != null){
            body.setAttendanceFact(mappedAttendance);
            scheduleCalendarClient.autoAttendance(body);
        }
    }


    @ApiOperation(value = "Журнал посещений",
            notes = "Отображение журнала посещения лекции с оценкми")
    @GetMapping("/lessonResults/{eventId}")
    public Observable<List<ResultJson>> getEventResults(@PathVariable @ApiParam(value = "ID события", example = "initialEvent_1") String eventId) {
        Observable<List<PersonJson>> persons = Observable.just(personalInfoClient.getPersonalInfoNB());
        Observable<List<LessionJson>> lessions = Observable.just(periodPlaningClient.getLessionList());
        Observable<List<ResultJson>> results = Observable.just(academicPerformanceClient.findResultByLessionId(eventId));



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

    private String mapAttendanceFactValue(String incomingAttendanceFact){
        return AttendanceFactMapper.mapValue(incomingAttendanceFact);
    }

}
