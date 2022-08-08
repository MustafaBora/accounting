package com.mustafabora.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class Transaction {

    String transactionId;
    String accountId;
    LocalDateTime time;
    BigDecimal value;

}
