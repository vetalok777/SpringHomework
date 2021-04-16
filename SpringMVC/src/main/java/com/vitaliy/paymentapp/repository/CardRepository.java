package com.vitaliy.paymentapp.repository;

import com.vitaliy.paymentapp.model.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository {
    Card createCard(Card card);

    Card getCard(String number);

    Card getCardByName(String name);

    Integer getCardId(String number);

    Integer getCardStatus(String number);

    List<Card> getAllCards();

    BigDecimal getCardBalance(String number);

    Card updateBalance(String number, BigDecimal value);

    Integer updateCardStatus(Integer cardId, Integer status);
}
