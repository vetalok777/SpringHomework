package com.vitaliy.paymentapp.service;

import com.vitaliy.paymentapp.dto.CardDto;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {
    CardDto getCard(String number);

    CardDto getCardByName(String name);

    List<CardDto> getAllCards();

    CardDto updateCardBalance(String number, BigDecimal value);

    CardDto updateCardStatus(Integer cardId, Integer status);

    CardDto createCard(CardDto cardDto);
}
