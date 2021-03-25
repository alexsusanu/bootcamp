package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAll(){
        List<Transaction> transactions = transactionRepository.findAll();
        Collections.sort(transactions, (t1, t2) -> t1.getDate().compareTo(t2.getDate()));
        return  transactions;
    }

    public Transaction findById(Long transactionId) {
        Optional<Transaction> transactionOptional = transactionRepository.findAll().stream().filter(transaction -> transaction.getId().equals(transactionId)).findAny();
        return transactionOptional.orElse(new Transaction());
    }
}
