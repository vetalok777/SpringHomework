package com.vitaliy.paymentapp.controller;

import com.vitaliy.paymentapp.dto.CardInfoDto;
import com.vitaliy.paymentapp.service.CardInfoService;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/card")
@AllArgsConstructor
public class MainController {

    private CardInfoService cardInfoService;

    @GetMapping("/cardInfo/{card}")
    public ResponseEntity<CardInfoDto> getCardInfo(@Valid @CreditCardNumber @PathVariable String card) {
        return ResponseEntity.status(HttpStatus.OK).body(cardInfoService.getCardInfoByNumber(card));
    }
}
