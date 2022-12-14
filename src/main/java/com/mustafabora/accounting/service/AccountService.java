package com.mustafabora.accounting.service;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.exception.TransactionServiceNotUpException;
import com.mustafabora.accounting.model.Account;
import com.mustafabora.accounting.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private static final String FIRST_TRANSACTION_TO_ACCOUNT = "http://localhost:8081/api/v1/transaction/firstTransactionToAccount";
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
     * @return transaction id
     */
    public String firstTransaction(Account acc, BigDecimal initialCredit) throws RestClientException {
        String newTransactionId;
        try {
            newTransactionId = callForCreateNewTransaction(acc, initialCredit);

        } catch (RestClientException restClientException) {
            throw new TransactionServiceNotUpException("Could not send first transaction!");
        }
        return newTransactionId;
    }

    private String callForCreateNewTransaction(Account acc, BigDecimal initialCredit) {
        String newTransactionId;
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("user-agent", "Application");

        //balance is also transaction value because there is only 1 transaction
        AccountDTO accountDTO = new AccountDTO(acc.getAccountId(), initialCredit);

        HttpEntity<AccountDTO> request = new HttpEntity<>(accountDTO, headers);

        newTransactionId = restTemplate.postForObject(FIRST_TRANSACTION_TO_ACCOUNT, request, String.class);
        return newTransactionId;
    }

    public Account getByAccountId(String accountId) {
        return repository.getByAccountId(accountId);
    }
}
