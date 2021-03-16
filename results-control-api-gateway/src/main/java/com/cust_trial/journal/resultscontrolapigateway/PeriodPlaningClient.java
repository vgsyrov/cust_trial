package com.cust_trial.journal.resultscontrolapigateway;

import com.cust_trial.journal.resultscontrolapigateway.Json.LessionJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.LessionParticipantJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${pp.service.name}", url = "${pp.service.url}")
public interface PeriodPlaningClient {

    //LessionController
    @GetMapping("/findLession/{id}")
    LessionJson findLessionById(@PathVariable String id);

    @GetMapping("/listLessions")
    List<LessionJson> getLessionList();


    //LessionPartisipantController
    @GetMapping("/listPartisipans")
    List<LessionParticipantJson> getListPartisipans();

    @GetMapping("/findLessionByLession/{id}")
    LessionParticipantJson findPartisipansByLessionId(@PathVariable String id);

    @GetMapping("/findLessionByPerson/{id}")
    List<LessionParticipantJson> findPartisipansByPersonId(@PathVariable String id) ;

}
