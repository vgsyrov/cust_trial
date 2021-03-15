package com.cust_trial.journal.resultscontrolapigateway;

import io.reactivex.Observable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

//@FeignClient(name = "piSvc", url = "localhost:8083")
@FeignClient(name = "${pi.service.name}", url = "${pi.service.url}")
@EnableAsync
public interface PersonalInfoClient {

//    @GetMapping("/list")
//    List getPersonalInfo();

    @GetMapping("/find/{id}")
    String findPersonById(@PathVariable String id);

    @GetMapping("/findName/{id}")
    String findFullNameById(@PathVariable String id);

    @GetMapping("/list")
    Observable<List<Map<String, String>>> getPersonalInfoNB();
}
