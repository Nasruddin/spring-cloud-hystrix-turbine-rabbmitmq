package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by nasir on 30/9/17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FastPassCustomer {

    private String fastPassId;
    private String customerFullName;
    private String fastPassPhone;
    private BigDecimal currentBalance;
}
