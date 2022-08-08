package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.model.Transaction;
import com.mustafabora.accounting.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TransactionService {

    TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public String save(AccountDTO accountDTO) {
        return repository.save(accountDTO);
    }

    public List<Transaction> listTransactions(String customerId) {

        RestTemplate restTemplate = new RestTemplate();

        List<String> accountIdlist = restTemplate.getForObject("http://localhost:8080/api/v1/account/accountIds/" + customerId, List.class);

        return repository.listTransactions(accountIdlist);
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransactions();

    }
}
