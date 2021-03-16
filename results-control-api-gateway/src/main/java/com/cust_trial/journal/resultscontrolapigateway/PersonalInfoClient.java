package com.cust_trial.journal.resultscontrolapigateway;

import com.cust_trial.journal.resultscontrolapigateway.Json.PersonJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${pi.service.name}", url = "${pi.service.url}")
@EnableAsync
public interface PersonalInfoClient {

    @GetMapping("/find/{id}")
    PersonJson findPersonById(@PathVariable String id);

    @GetMapping("/list")
    List<PersonJson> getPersonalInfoNB();
}
