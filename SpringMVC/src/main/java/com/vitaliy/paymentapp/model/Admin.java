package com.vitaliy.paymentapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin {

    private Integer id;
    private String password;
    private String login;
}
