package com.vitaliy.paymentapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UnblockRequest {

    private Integer id;
    private String status;
    private LocalDateTime creationDate;
    private Integer consideredByAdmin;
    private Integer cardId;
}
