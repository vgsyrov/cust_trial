package com.cust_trial.journal.resultscontrolapigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PersonalInfoClient personalInfoClient;

    @GetMapping("/ping2")
    public List getPersonList() {
        return personalInfoClient.getPersonalInfo();
    }
}
