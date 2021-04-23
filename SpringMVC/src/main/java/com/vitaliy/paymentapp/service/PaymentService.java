package com.vitaliy.paymentapp.service;

import com.vitaliy.paymentapp.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto getPayment(Integer id);

    List<PaymentDto> getAllPayments();

    PaymentDto createPayment(PaymentDto paymentDto);

    PaymentDto updateStatus(String status, Integer id);
}
