package com.mustafabora.accounting.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class OutputDTO {
    String customerID;
    BigDecimal initialCredit;
    String name;
    String surname;
    List<AccountInfo> accountInfos;
}

