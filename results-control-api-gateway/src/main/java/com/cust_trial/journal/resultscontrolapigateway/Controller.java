package com.cust_trial.journal.resultscontrolapigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
public class Controller {

    @Autowired
    PersonalInfoClient personalInfoClient;

    @Autowired
    PeriodPlaningClient periodPlaningClient;

    @GetMapping("/ping2")
    public Mono<ServerResponse> getPersonList() {
        //List<Map<String, String>> l = personalInfoClient.getPersonalInfoNB();
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("OK", String.class);
//        List l = personalInfoClient.getPersonalInfoNB().collectList().block();
//        return l;
        //return String.valueOf(personalInfoClient.getPersonalInfo().size());
    }

    @GetMapping("/periodPlaningList")
    public List getPeriodPlaning() {
        final String PERSON_ID = "personId";
        final String LESSION_ID = "lessionId";

        List<Map<String, String>> partisipans = periodPlaningClient.getListPartisipans();
        List returnValue = partisipans.stream()
                .peek(x -> System.out.println(x.get(PERSON_ID)))
                .peek(x -> x.put(PERSON_ID, personalInfoClient.findFullNameById(x.get(PERSON_ID))))
                .peek(x -> x.put(LESSION_ID, periodPlaningClient.findLessionById(x.get(LESSION_ID))))
                .collect(Collectors.toList());
        return returnValue;
    }
}
