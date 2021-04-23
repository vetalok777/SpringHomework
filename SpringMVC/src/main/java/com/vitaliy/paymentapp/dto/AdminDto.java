package com.vitaliy.paymentapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {
    private String password;
    private String login;
}
