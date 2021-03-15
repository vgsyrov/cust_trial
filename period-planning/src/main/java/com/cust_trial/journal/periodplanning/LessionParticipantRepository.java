package com.cust_trial.journal.periodplanning;

import com.cust_trial.journal.periodplanning.Entity.LessionParticipant;
import com.cust_trial.journal.periodplanning.Entity.LessionPartisipantId;
import org.springframework.data.repository.CrudRepository;

public interface LessionParticipantRepository extends CrudRepository<LessionParticipant, LessionPartisipantId> {
    LessionParticipant findLessionByLessionId(String id);

    Iterable<LessionParticipant> findLessionByPersonId(String id);

    Iterable<LessionParticipant> findAll();
}
