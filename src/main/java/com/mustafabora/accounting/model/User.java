package com.mustafabora.accounting.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    String customerID;
    BigDecimal initialCredit;
    String name;
    String surname;
    BigDecimal balance;
}
