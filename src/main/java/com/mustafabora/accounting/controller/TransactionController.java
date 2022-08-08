package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.model.Transaction;
import com.mustafabora.accounting.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
@AllArgsConstructor
public class TransactionController {

    TransactionService service;

    @PostMapping
    public String save(@RequestBody AccountDTO accountDTO) {
        return service.save(accountDTO);
    }

    @GetMapping(value = "/transactions/{customerId}")
    public List<Transaction> listTransactions(@PathVariable String customerId) {
        return service.listTransactions(customerId);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

}
