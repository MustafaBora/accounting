package com.mustafabora.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Account {

    private String customerID;
    private BigDecimal balance;
}
