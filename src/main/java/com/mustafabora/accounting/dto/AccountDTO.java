package com.mustafabora.accounting.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Used in Transaction Controller
 */
@Data
public class AccountDTO {

    private final String accountID;
    private final BigDecimal value;
}
