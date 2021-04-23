package com.vitaliy.paymentapp.repository.impl;

import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.model.Payment;
import com.vitaliy.paymentapp.model.User;
import com.vitaliy.paymentapp.repository.PaymentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {

    List<Payment> payments = new ArrayList<>();

    @Override
    public Payment createPayment(Payment payment) {
        payments.add(payment);
        return payment;
    }

    @Override
    public List<Payment> getAllPayments() {
        return payments;
    }

    @Override
    public Payment getPayment(Integer id) {
        return payments.stream()
                .filter(payment -> payment.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get payment"));
    }

    @Override
    public Payment updatePaymentStatus(String status, Integer id) {
        Payment payment = getPayment(id);
        payment.setStatus(status);
        return payment;
    }
}
