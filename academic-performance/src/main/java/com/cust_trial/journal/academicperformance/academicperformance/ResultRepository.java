package com.cust_trial.journal.academicperformance.academicperformance;

import com.cust_trial.journal.academicperformance.academicperformance.Entity.Result;
import com.cust_trial.journal.academicperformance.academicperformance.Entity.ResultType;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, String> {

    Iterable<Result> findResultsByPersonId(String personId);

    Iterable<Result> findAll();

    Iterable<Result> findResultsByLessionId(String lessionId);

    Result findByLessionIdAndPersonIdAndResultType(String lessionId, String PersonId, ResultType resultType);
}
