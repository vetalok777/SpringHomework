package com.vitaliy.paymentapp.controller;

import com.vitaliy.paymentapp.dto.PaymentDto;
import com.vitaliy.paymentapp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
@Slf4j
public class PaymentController {


    private final PaymentService paymentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto getPayment(@PathVariable Integer id) {
        log.info("Get payment: " + paymentService.getPayment(id));
        return paymentService.getPayment(id);
    }

    @GetMapping("/allPayments")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentDto> getAllPayments() {
        log.info("Get all payments: " + paymentService.getAllPayments());
        return paymentService.getAllPayments();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto) {
        log.info("Create payment: " + paymentDto);
        return paymentService.createPayment(paymentDto);
    }

    @PutMapping("/changeStatus/{status}{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto updatePaymentStatus(@PathVariable String status, @PathVariable Integer id) {
        log.info("Update payment status: " + status + ", " + id);
        return paymentService.updateStatus(status, id);
    }

}
