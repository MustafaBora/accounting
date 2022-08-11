package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.dto.TransactionDTO;
import com.mustafabora.accounting.exception.AccountServiceNotUpException;
import com.mustafabora.accounting.exception.CustomerNotFoundException;
import com.mustafabora.accounting.model.Transaction;
import com.mustafabora.accounting.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private static final String ACCOUNT_IDS = "http://localhost:8090/api/v1/account/accountIds/";

    TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }


    public String saveFirstTransactionToNewAccount(AccountDTO accountDTO) {
        return repository.saveFirstTransactionToNewAccount(accountDTO);
    }

    public String save(AccountDTO accountDTO) {
        return repository.save(accountDTO);
    }

    public List<Transaction> getTransactionsByCustomerId(String customerId) {

        RestTemplate restTemplate = new RestTemplate();
        List<String> accountIdlist;
        try {
            accountIdlist = restTemplate.getForObject(ACCOUNT_IDS + customerId, List.class);
            if(accountIdlist == null) throw new CustomerNotFoundException(customerId + " doesn't have any account! " + customerId);
            return repository.listTransactions(accountIdlist);
        }
        catch (RestClientException connectException) {
            throw new AccountServiceNotUpException("Account service unreachable while getting account numbers of " + customerId);
        }

    }

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransactions();

    }

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        return repository.getTransactionsByAccountId(accountId);
    }

    public List<TransactionDTO> convertToDTO(List<Transaction> transactionList) {
        if(transactionList == null) return new ArrayList<>();
        return transactionList.stream().map(tran ->
                        new TransactionDTO(tran.getTransactionId(), tran.getAccountId(), tran.getTime(), tran.getValue()))
                .collect(Collectors.toList());
    }
}
