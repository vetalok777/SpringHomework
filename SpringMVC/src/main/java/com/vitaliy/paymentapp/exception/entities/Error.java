package com.vitaliy.paymentapp.exception.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class Error {
    private Date timestamp;
    private String message;
    private String details;

}
