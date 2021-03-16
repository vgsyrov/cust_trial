package com.cust_trial.journal.resultscontrolapigateway.client;


import com.cust_trial.journal.resultscontrolapigateway.Json.ResultJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${ap.service.name}", url = "${ap.service.url}")
public interface AcademicPerformanceClient {

    @GetMapping("/list")
    List<ResultJson> getResultList();

    @GetMapping("/findByPerson/{id}")
    List<ResultJson>  findResultByPersonId(@PathVariable String id);

    @GetMapping("/findByLession/{id}")
    List<ResultJson>  findResultByLessionId(@PathVariable String id);
}
