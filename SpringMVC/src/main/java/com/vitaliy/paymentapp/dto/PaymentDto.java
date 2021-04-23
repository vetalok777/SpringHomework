package com.vitaliy.paymentapp.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentDto {
    private BigDecimal amount;
    private LocalDateTime date;
    private String status;
    private Integer sender_id;
    private Integer receiver_id;
}
