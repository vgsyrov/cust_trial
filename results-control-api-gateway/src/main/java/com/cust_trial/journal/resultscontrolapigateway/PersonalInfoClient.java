package com.cust_trial.journal.resultscontrolapigateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "piSvc", url = "localhost:8083")
@FeignClient(name = "${pi.service.name}", url = "${pi.service.url}")
public interface PersonalInfoClient {

    @GetMapping("/list")
    List getPersonalInfo();

    @GetMapping("/find/{id}")
    String findPersonById(@PathVariable String id);

    @GetMapping("/findName/{id}")
    String findFullNameById(@PathVariable String id);
}
