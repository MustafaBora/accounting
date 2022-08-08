package com.mustafabora.accounting.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OutputDTO {
    String customerID;
    BigDecimal initialCredit;
    String name;
    String surname;
    BigDecimal balance;
    List<TransactionDTO> transactionDTOList;
}
