package com.mustafabora.accounting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@RequiredArgsConstructor
public class User {

    String customerID;
    BigDecimal initialCredit;
    String name;
    String surname;
    BigDecimal balance;
}
