package com.vitaliy.paymentapp.controller;

import com.vitaliy.paymentapp.dto.CardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.vitaliy.paymentapp.service.CardService;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Slf4j
public class CardController {


    private final CardService cardService;

    @GetMapping("/number/{number}")
    @ResponseStatus(HttpStatus.OK)
    public CardDto getCard(@PathVariable String number) {
        log.info("Get card: " + number);
        return cardService.getCard(number);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CardDto getCardByName(@PathVariable String name) {
        log.info("Get card by name: " + name);
        return cardService.getCardByName(name);
    }

    @GetMapping("/allCards}")
    @ResponseStatus(HttpStatus.OK)
    public List<CardDto> getAllCards() {
        log.info("Get all cards: " + cardService.getAllCards());
        return cardService.getAllCards();
    }

    @PutMapping("/updateBalance/{number}{value}")
    @ResponseStatus(HttpStatus.OK)
    public CardDto updateCardBalance(@PathVariable String number, @PathVariable BigDecimal value) {
        log.info("Update card balance: " + number + ", " + value);
        return cardService.updateCardBalance(number, value);
    }

    @PutMapping("/updateStatus/{cardId}{status}")
    @ResponseStatus(HttpStatus.OK)
    public CardDto changeCardStatus(@PathVariable Integer cardId, @PathVariable Integer status) {
        log.info("Update card status: " + cardId + ", " + status);
        return cardService.updateCardStatus(cardId, status);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CardDto createCard(@RequestBody CardDto cardDto) {
        log.info("Create card: " + cardDto);
        return cardService.createCard(cardDto);
    }
}
