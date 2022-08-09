package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.dto.AccountInfo;
import com.mustafabora.accounting.model.Account;
import com.mustafabora.accounting.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account save(String customerID, BigDecimal initialCredit) {
        return this.repository.save(customerID, initialCredit);
    }

    public List<Account> getByCustomerId(String customerId) {
        return repository.getByCustomerId(customerId);
    }

    public List<String> getAccountIdsByCustomerId(String customerId) {
        return repository.getAccountIdsByCustomerId(customerId);
    }

    /**
     * introduces a transaction to given account via HTTP call
     */
    public String firstTransaction(Account acc, BigDecimal initialCredit) {

        RestTemplate restTemplate = new RestTemplate();

        // Create the request body as a MultiValueMap
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

        headers.add("user-agent", "Application");

        //balance is also transaction value because there is only 1 transaction
        AccountDTO accountDTO = new AccountDTO(acc.getAccountId(), initialCredit);

        HttpEntity<AccountDTO> request = new HttpEntity<>(accountDTO, headers);

        String transactionId = restTemplate.postForObject("http://localhost:8080/api/v1/transaction/firstTransactionToAccount", request, String.class);

        return transactionId;
    }

    public Account getByAccountId(String accountId) {
        return repository.getByAccountId(accountId);
    }
}
