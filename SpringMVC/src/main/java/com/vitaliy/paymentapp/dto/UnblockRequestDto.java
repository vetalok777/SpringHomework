package com.vitaliy.paymentapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UnblockRequestDto {
    private String status;
    private LocalDateTime creationDate;
    private Integer consideredByAdmin;
    private Integer cardId;
}
