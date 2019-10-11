package com.arysbek.moneytransferapp;


import com.arysbek.moneytransferapp.model.Transaction;
import com.arysbek.moneytransferapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    //Read all transactions
    @GetMapping("/")
    public ResponseEntity<Iterable<Transaction>> findAll() {
        try {
            Iterable<Transaction> transactions = transactionRepository.findAll();
            if (transactions.iterator().hasNext()) {
                return ResponseEntity.ok(transactions);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    // Read One Transaction
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if(!optionalTransaction.isPresent()){
            return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTransaction.get(),HttpStatus.OK);
    }

    // Read transaction by User_id


}
