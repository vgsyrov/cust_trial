package com.cust_trial.journal.academicperformance.academicperformance;

import com.cust_trial.journal.academicperformance.academicperformance.Entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/list")
    public Iterable<Result> getResultList() {
        return resultRepository.findAll();
    }

    @GetMapping("/findByPerson/{id}")
    public Iterable<Result> findResultByPersonId(@PathVariable String id) {
        return resultRepository.findResultsByPersonId(id);
    }

    @GetMapping("/findByLession/{id}")
    public Iterable<Result> findResultByLessionId(@PathVariable String id) {
        return resultRepository.findResultsByLessionId(id);
    }


}
