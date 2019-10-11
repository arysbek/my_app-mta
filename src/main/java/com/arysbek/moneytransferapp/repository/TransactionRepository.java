package com.arysbek.moneytransferapp.repository;

import com.arysbek.moneytransferapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    //Custom queries for transaction findBy== Select from Transaction where user_id is(id)
    Iterable<Transaction> findByUserId(Long id);
}
