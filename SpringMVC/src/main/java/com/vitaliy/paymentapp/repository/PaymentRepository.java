package com.vitaliy.paymentapp.repository;

import com.vitaliy.paymentapp.model.Payment;

import java.util.List;

public interface PaymentRepository {
    Payment createPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPayment(Integer id);

    String updatePaymentStatus(String status, Integer id);
}
