package com.cust_trial.journal.resultscontrolapigateway;

import com.cust_trial.journal.resultscontrolapigateway.Json.LessionJson;
import com.cust_trial.journal.resultscontrolapigateway.Json.LessionParticipantJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${pp.service.name}", url = "${pp.service.url}")

public interface PeriodPlaningClient {

    @GetMapping("/listPartisipans")
    List<LessionParticipantJson> getListPartisipans();

    @GetMapping("/findLessionByLession/{id}")
    String findPartisipansByLessionId(@PathVariable String id);

    @GetMapping("/findLessionByPerson/{id}")
    List findPartisipansByPersonId(@PathVariable String id) ;

    @GetMapping("/findLession/{id}")
    String findLessionById(@PathVariable String id);

    @GetMapping("/listLessions")
    List<LessionJson> getLessionList();

}
