package com.mustafabora.accounting.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
// is it needed because it's the same as Transaction
    String transactionId;
    String accountId;
    LocalDateTime time;
    BigDecimal value;
}
