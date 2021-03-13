package com.cust_trial.journal.periodplanning;

import com.cust_trial.journal.periodplanning.Entity.Lession;
import org.springframework.data.repository.CrudRepository;

public interface LessionRepository extends CrudRepository<Lession, String> {

    Lession findLessionByLessionId(String id);

    Iterable<Lession> findAll();
}
