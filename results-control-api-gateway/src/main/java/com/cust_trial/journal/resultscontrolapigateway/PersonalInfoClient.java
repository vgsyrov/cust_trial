package com.cust_trial.journal.resultscontrolapigateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "piSvc", url = "localhost:8083")
public interface PersonalInfoClient {

    @GetMapping("/list")
    List getPersonalInfo();
}
