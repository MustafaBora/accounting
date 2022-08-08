package com.mustafabora.accounting.repository;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AccountRepository {

    Map<String, List<Account>> accountMap = new HashMap<>();    //accounts by customerId
    private final int sequenceIncrease = 1;
    private int sequence = 5;   //can be volatile

    AccountRepository() {
        initAccounts();
    }

    private void initAccounts() {
        ArrayList<Account> bil1 = new ArrayList<>();
        bil1.add(new Account("1", "1BIL", BigDecimal.ZERO));
        ArrayList<Account> cyb2 = new ArrayList<>();
        cyb2.add(new Account("2", "2CYB", BigDecimal.ZERO));
        ArrayList<Account> hvl3 = new ArrayList<>();
        hvl3.add(new Account("3", "3HVL", BigDecimal.ZERO));
        ArrayList<Account> cpg4 = new ArrayList<>();
        cpg4.add(new Account("4", "4CGM", BigDecimal.ZERO));
        accountMap.put("1BIL", bil1);
        accountMap.put("2CYB", cyb2);
        accountMap.put("3HVL", hvl3);
        accountMap.put("4CGM", cpg4);
    }


    /**
     * Creates a brand new account and adds to the customer
     * @return new account id
     */
    public Account save(String customerID, BigDecimal initialCredit) {
        sequence += sequenceIncrease;   //account id increases sequentially
        Account accNew = new Account(
                String.valueOf(sequence),
                customerID,
                initialCredit);
        this.accountMap.get(customerID).add(accNew);
        return accNew;
    }

    public List<Account> getByCustomerId(String customerId) {
        return accountMap.get(customerId);
    }

    public List<String> getAccountIdsByCustomerId(String customerId) {
        return this.accountMap.get(customerId).stream().map(Account::getAccountId).collect(Collectors.toList());
    }

}
