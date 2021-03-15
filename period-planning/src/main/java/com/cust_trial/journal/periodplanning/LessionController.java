package com.cust_trial.journal.periodplanning;

import com.cust_trial.journal.periodplanning.Entity.Lession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessionController {

    @Autowired
    private LessionRepository lessionRepository;

    @GetMapping("/listLessions")
    public Iterable<Lession> getLessionList() {
        return lessionRepository.findAll();
    }

    @GetMapping("/findLessionL/{id}")
    public Lession findLessionEntitById(@PathVariable String id) {
        return lessionRepository.findLessionByLessionId(id);
    }

    @GetMapping("/findLession/{id}")
    public String findLessionById(@PathVariable String id) {
        return lessionRepository.findLessionByLessionId(id).getLessionName();
    }



}
