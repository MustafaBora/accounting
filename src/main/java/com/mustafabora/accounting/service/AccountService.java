package com.mustafabora.accounting.service;

import com.mustafabora.accounting.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@AllArgsConstructor
public class AccountService {

    Map<String, Account> accountMap;

    public void save(String customerID) {
        this.accountMap.put(customerID, new Account(customerID, BigDecimal.ZERO));
    }

    public void setBalance(String customerID, BigDecimal initialCredit) {
        accountMap.put(customerID, new Account(customerID, initialCredit));
    }
}
