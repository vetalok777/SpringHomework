package com.vitaliy.paymentapp.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CardDto {
    private String name;
    private String number;
    private BigDecimal balance;
    private Boolean status;
}
