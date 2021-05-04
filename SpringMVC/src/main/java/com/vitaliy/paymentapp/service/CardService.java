package com.vitaliy.paymentapp.service;

import com.vitaliy.paymentapp.dto.CardDto;
import com.vitaliy.paymentapp.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {
    CardDto getCard(String number);

    CardDto getCardByName(String name);

    List<CardDto> getAllCards();

    CardDto updateCardBalance(String number, BigDecimal value, String action) throws Exception;

    CardDto updateCardStatus(Integer cardId, boolean status);

    CardDto createCard(CardDto cardDto, User user);
}
