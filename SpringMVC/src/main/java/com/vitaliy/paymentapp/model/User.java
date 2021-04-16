package com.vitaliy.paymentapp.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private Integer status;

}
