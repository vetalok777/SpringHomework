package com.vitaliy.paymentapp.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Payment {
    private Integer id;
    private BigDecimal amount;
    private LocalDateTime date;
    private String status;
    private Integer sender_id;
    private Integer receiver_id;
}
