package com.mustafabora.accounting.controller;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.dto.TransactionDTO;
import com.mustafabora.accounting.model.Transaction;
import com.mustafabora.accounting.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
@AllArgsConstructor
@Profile("transactions")
public class TransactionController {

    TransactionService service;

    @PostMapping
    public String save(@RequestBody AccountDTO accountDTO) {
        return service.save(accountDTO);
    }

    /**
     * @return new transaction ID
     */
    @PostMapping(value = "/firstTransactionToAccount")
    public String saveFirstTransactionToNewAccount(@RequestBody AccountDTO accountDTO) {
        return service.saveFirstTransactionToNewAccount(accountDTO);
    }

    @GetMapping(value = "/transactionsByCustomerId/{customerId}")
    public List<TransactionDTO> getTransactionsByCustomerId(@PathVariable String customerId) {
        return service.convertToDTO(
                service.getTransactionsByCustomerId(customerId) );
    }

    @GetMapping(value = "/transactionsByAccountId/{accountId}")
    public List<TransactionDTO> getTransactionsByAccountId(@PathVariable String accountId) {
        return service.convertToDTO(
                service.getTransactionsByAccountId(accountId)
        );
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

}
