package com.cust_trial.journal.personalinfosvc.personalinformation;

import com.cust_trial.journal.personalinfosvc.personalinformation.Entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

    Person findPersonByPersonId(String id);

    Iterable<Person> findAll();

}
