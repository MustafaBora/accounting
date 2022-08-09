package com.mustafabora.accounting.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDTO {
    String transactionId;
    String accountId;
    LocalDateTime time;
    BigDecimal value;
}
