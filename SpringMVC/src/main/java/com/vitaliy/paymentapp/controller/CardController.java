package com.vitaliy.paymentapp.controller;

import com.vitaliy.paymentapp.controller.assembler.CardAssembler;
import com.vitaliy.paymentapp.controller.model.CardModel;
import com.vitaliy.paymentapp.dto.CardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.vitaliy.paymentapp.service.CardService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
@Slf4j
public class CardController {


    private final CardService cardService;
    private final CardAssembler cardAssembler;

    @GetMapping("/number/{number}")
    @ResponseStatus(HttpStatus.OK)
    public CardModel getCard(@PathVariable String number) {
        log.info("Get card: " + number);
        CardDto cardDto = cardService.getCard(number);
        return cardAssembler.toModel(cardDto);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CardModel getCardByName(@PathVariable String name) {
        log.info("Get card by name: " + name);
        CardDto cardDto = cardService.getCardByName(name);
        return cardAssembler.toModel(cardDto);
    }

    @GetMapping("/allCards}")
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<CardModel> getAllCards() {
        log.info("Get all cards: " + cardService.getAllCards());

        List<CardModel> list = cardService.getAllCards().stream()
                .map(cardAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(list);
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
    public CardModel createCard(@RequestBody CardDto cardDto) {
        log.info("Create card: " + cardDto);
        CardDto card = cardService.createCard(cardDto);
        return cardAssembler.toModel(card);
    }
}
