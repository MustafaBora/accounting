package com.mustafabora.accounting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AccountInfo {
    String customerId;
    String accountId;
    BigDecimal balance;
    List<TransactionDTO> transactionDTOList;

}
