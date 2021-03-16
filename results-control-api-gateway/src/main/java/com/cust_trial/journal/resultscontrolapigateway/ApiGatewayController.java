package com.cust_trial.journal.resultscontrolapigateway;

import com.cust_trial.journal.resultscontrolapigateway.Json.LessionJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.LessionParticipantJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.PersonJson;
import com.cust_trial.journal.resultscontrolapigateway.client.PeriodPlaningClient;
import com.cust_trial.journal.resultscontrolapigateway.client.PersonalInfoClient;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ApiGatewayController {

    @Autowired
    PersonalInfoClient personalInfoClient;

    @Autowired
    PeriodPlaningClient periodPlaningClient;


    @GetMapping("/periodPlaningList")
    public Observable<List<LessionParticipantJson>> getPeriodPlaning() {
        Observable<List<PersonJson>> persons = Observable.just(personalInfoClient.getPersonalInfoNB());
        Observable<List<LessionParticipantJson>> partisipans = Observable.just(periodPlaningClient.getListPartisipans());
        Observable<List<LessionJson>> lessions = Observable.just(periodPlaningClient.getLessionList());


        return Observable.zip(persons, partisipans, lessions,
                (List<PersonJson> p, List<LessionParticipantJson> lp, List<LessionJson> l) -> combine(p, lp, l))
                .cache();
    }

    private List<LessionParticipantJson> combine(List<PersonJson> personJsons,
                                                 List<LessionParticipantJson> participantJsons,
                                                 List<LessionJson> lessions) {
        System.out.println();
        Map<String, PersonJson> personMap = new HashMap<>(personJsons.size());
        Map<String, LessionJson> lessionMap = new HashMap<>(lessions.size());

        personJsons.forEach(item -> personMap.put(item.getPersonId(), item));
        lessions.forEach(item -> lessionMap.put(item.getLessionId(), item));

        participantJsons
                .stream().peek(item -> item.setPersonName(personMap.get(item.getPersonId()).getFullName()))
                .forEach(item -> item.setLessionName(lessionMap.get(item.getLessionId()).getLessionName()));

        return participantJsons;
    }

}
