package com.cust_trial.journal.resultscontrolapigateway;

import com.cust_trial.journal.resultscontrolapigateway.Json.LessionJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.LessionParticipantJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.PersonJson;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    @Autowired
    PersonalInfoClient personalInfoClient;

    @Autowired
    PeriodPlaningClient periodPlaningClient;

//    @GetMapping("/ping2")
//    public Mono<ServerResponse> getPersonList() {
//        //List<Map<String, String>> l = personalInfoClient.getPersonalInfoNB();
//        return ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body("OK", String.class);
////        List l = personalInfoClient.getPersonalInfoNB().collectList().block();
////        return l;
//        //return String.valueOf(personalInfoClient.getPersonalInfo().size());
//    }

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

    @GetMapping("/periodPlaningList")
    public Observable<List<LessionParticipantJson>> getPeriodPlaning() {

        //WORKING
//        return Observable.just(personalInfoClient.getPersonalInfoNB());

        Observable<List<PersonJson>> persons = Observable.just(personalInfoClient.getPersonalInfoNB());
        Observable<List<LessionParticipantJson>> partisipans = Observable.just(periodPlaningClient.getListPartisipans());
        Observable<List<LessionJson>> lessions = Observable.just(periodPlaningClient.getLessionList());

        /*
        Observable.zip(obs1, obs2, obs3, (Integer i, String s, Boolean b) -> i + " " + s + " " + b)
                .subscribe(str -> System.out.println(str));

         */

        return Observable.zip(persons, partisipans, lessions,
                (List<PersonJson> p, List<LessionParticipantJson> lp, List<LessionJson> l) -> combine(p, lp, l))
                .cache();



//        final String PERSON_ID = "personId";
//        final String LESSION_ID = "lessionId";
//
//        List<PersonJson> ll = new ArrayList<>();
//
//        Observable.just(personalInfoClient.getPersonalInfoNB())
//                .subscribeOn(Schedulers.computation())
//                .observeOn(Schedulers.io())
//                .subscribe(new Consumer<List<PersonJson>>() {
//                    @Override
//                    public void accept(final List<PersonJson> list) throws Exception {
//                        ll.addAll(list);
//                        System.out.println("Got data:"+ll.size());
//                    }
//                });
//
//
//        try {
//            System.out.println(ll.size());
//            Thread.sleep(1000);
//            System.out.println(ll.size());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        List<List<PersonJson>> l =personalInfoClient.getPersonalInfoNB().toList().blockingGet();


//        List<List<PersonJson>> l = personalInfoClient.getPersonalInfoNB().toList().blockingGet();

//        return Collections.emptyList();

//        List<PersonJson> partisipans = periodPlaningClient.getListPartisipans();
//        return par
//        List returnValue = partisipans.stream()
//                .peek(x -> System.out.println(x.get(PERSON_ID)))
//                .peek(x -> x.put(PERSON_ID, personalInfoClient.findFullNameById(x.get(PERSON_ID))))
//                .peek(x -> x.put(LESSION_ID, periodPlaningClient.findLessionById(x.get(LESSION_ID))))
//                .collect(Collectors.toList());
//        return returnValue;
    }
}
