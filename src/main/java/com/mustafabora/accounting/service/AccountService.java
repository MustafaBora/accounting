package com.mustafabora.accounting.service;

import com.mustafabora.accounting.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void save(String customerID, BigDecimal initialCredit) {
        this.accountRepository.save(customerID, initialCredit);
    }

}
