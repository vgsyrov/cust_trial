package com.cust_trial.journal.periodplanning;

import com.cust_trial.journal.periodplanning.Entity.LessionParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessionPartisipantController {

    @Autowired
    private LessionParticipantRepository lessionParticipantRepository;

    @GetMapping("/listPartisipans")
    public Iterable<LessionParticipant> getPartisipanList() {
        return lessionParticipantRepository.findAll();
    }


    @GetMapping("/findLessionByLession/{id}")
    public Iterable<LessionParticipant> findPartisipansByLessionId(@PathVariable String id) {
        return lessionParticipantRepository.findLessionByLessionId(id);
    }

    @GetMapping("/findLessionByPerson/{id}")
    public Iterable<LessionParticipant> findPartisipansByPersonId(@PathVariable String id) {
        return lessionParticipantRepository.findLessionByPersonId(id);
    }

}
