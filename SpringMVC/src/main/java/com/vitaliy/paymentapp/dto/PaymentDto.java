package com.vitaliy.paymentapp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDto {
    private BigDecimal amount;
    private LocalDateTime date;
    private String status;
    private Integer sender_id;
    private Integer receiver_id;
}
