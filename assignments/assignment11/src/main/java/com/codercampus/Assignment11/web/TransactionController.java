package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions")
    public String getTransactions(ModelMap modelMap){
        List<Transaction> transactionList = transactionService.getAll();

        modelMap.put("transactions", transactionList);
        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getTransaction(ModelMap modelMap, @PathVariable Long transactionId){
        Transaction trns = transactionService.findById(transactionId);
        modelMap.put("transaction", trns);
        return "transaction";
    }
}
