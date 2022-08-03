package com.mustafabora.accounting.repository;

import com.mustafabora.accounting.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {

    Map<String, Account> accountMap = new HashMap<>();

    /**
     * Creates a brand new account overriding the former value if such exists.
     */
    public void save(String customerID, BigDecimal initialCredit) {
        this.accountMap.put(customerID, new Account(customerID, initialCredit));
    }
}
