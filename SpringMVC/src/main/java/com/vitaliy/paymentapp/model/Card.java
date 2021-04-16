package com.vitaliy.paymentapp.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Card {
    private Integer id;
    private String name;
    private String number;
    private BigDecimal balance;
    private Integer status;
    private Integer userId;
}
