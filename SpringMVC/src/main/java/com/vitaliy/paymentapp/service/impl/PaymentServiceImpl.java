package com.vitaliy.paymentapp.service.impl;

import com.vitaliy.paymentapp.dto.CardDto;
import com.vitaliy.paymentapp.dto.PaymentDto;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.model.Payment;
import com.vitaliy.paymentapp.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements com.vitaliy.paymentapp.service.PaymentService {

    private final PaymentRepository paymentRepository;


    @Override
    public PaymentDto getPayment(Integer id) {
        Payment payment = paymentRepository.getPayment(id);
        return mapPaymentToPaymentDto(payment);
    }


    @Override
    public List<PaymentDto> getAllPayments() {
        return paymentRepository.getAllPayments().stream()
                .map(this::mapPaymentToPaymentDto)
                .collect(Collectors.toList());
    }


    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment = mapPaymentDtoToPayment(paymentDto);
        payment = paymentRepository.createPayment(payment);
        return mapPaymentToPaymentDto(payment);
    }

    @Override
    public PaymentDto updateStatus(String status, Integer id) {
        Payment payment = paymentRepository.updatePaymentStatus(status, id);
        return mapPaymentToPaymentDto(payment);
    }


    private PaymentDto mapPaymentToPaymentDto(Payment payment) {
        return PaymentDto.builder()
                .amount(payment.getAmount())
                .date(payment.getDate())
                .status(payment.getStatus())
                .receiver_id(payment.getReceiver_id())
                .sender_id(payment.getSender_id())
                .build();
    }

    private Payment mapPaymentDtoToPayment(PaymentDto paymentDto) {
        return Payment.builder()
                .amount(paymentDto.getAmount())
                .date(paymentDto.getDate())
                .status(paymentDto.getStatus())
                .receiver_id(paymentDto.getReceiver_id())
                .sender_id(paymentDto.getSender_id())
                .build();

    }
}
