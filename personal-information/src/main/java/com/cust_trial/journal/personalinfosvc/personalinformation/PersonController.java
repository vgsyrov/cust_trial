package com.cust_trial.journal.personalinfosvc.personalinformation;


import com.cust_trial.journal.personalinfosvc.personalinformation.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/list")
    public Iterable<Person> getPersonList() {
        return personRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Person findPersonById(@PathVariable String id) {
        return personRepository.findPersonByPersonId(id);
    }
}
