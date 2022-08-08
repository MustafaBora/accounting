package com.mustafabora.accounting.repository;

import com.mustafabora.accounting.dto.AccountDTO;
import com.mustafabora.accounting.model.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {

    private Map<String, List<Transaction>> transactions = new HashMap<>();    //transactions by accountId
    private final int sequenceIncrease = 100;
    private int transactionsSequence = 10;  //can be volatile

    TransactionRepository() {
        List<Transaction> bil1Transactions = new ArrayList<>();
        bil1Transactions.add(new Transaction("0","1", LocalDateTime.now(), BigDecimal.ZERO));
        transactions.put("1", bil1Transactions);
    }

    public String save(AccountDTO accountDTO) {
        initTransactionsList(accountDTO);
        String newtransactionID = String.valueOf(transactionsSequence + sequenceIncrease);
        transactionsSequence += sequenceIncrease;
        Transaction newTransaction = new Transaction(
            newtransactionID,
            accountDTO.getAccountID(),
            LocalDateTime.now(),
            accountDTO.getValue()
        );
        transactions.get(accountDTO.getAccountID()).add(
            newTransaction);
        return newtransactionID;
    }

    private void initTransactionsList(AccountDTO accountDTO) {
        transactions.computeIfAbsent(accountDTO.getAccountID(), k -> new ArrayList<>());
    }

    public List<Transaction> listTransactions(List<String> accountIds) {
        return accountIds.stream()
                .filter(acc -> transactions.get(acc) != null)
                .flatMap(acc -> transactions.get(acc).stream())
                .collect(Collectors.toList());
//        return accountIds.stream().map(acc -> transactions.get(acc)).flatMap(tran -> tran.stream()).collect(Collectors.toList());
//        return accountIds.stream()
//                .flatMap(acc -> transactions.get(acc).stream())
//                .collect(Collectors.toList());
    }

    /**
     * normally this method does not get implemented
     * @return all transactions in a list
     */
    public List<Transaction> getAllTransactions() {
        return transactions.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
