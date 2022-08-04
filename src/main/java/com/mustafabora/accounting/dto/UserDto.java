package com.mustafabora.accounting.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDto {

    private final String customerID;
    private final BigDecimal initialCredit;
}
