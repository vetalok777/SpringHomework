package com.vitaliy.paymentapp.repository.impl;

import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.repository.CardRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class CardRepositoryImpl implements CardRepository {

    private List<Card> cards = new ArrayList<>();


    @Override
    public Card createCard(Card card) {
        cards.add(card);
        return card;
    }

    @Override
    public Card getCard(String number) {
        return cards.stream()
                .filter(card -> card.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get card"));
    }

    @Override
    public Card getCardByName(String name) {
        return cards.stream()
                .filter(card -> card.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get card"));
    }

    @Override
    public Integer getCardId(String number) {
        return cards.stream()
                .filter(card -> card.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get card id"))
                .getId();
    }

    @Override
    public Integer getCardStatus(String number) {
        return cards.stream()
                .filter(card -> card.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get card status"))
                .getStatus();
    }

    @Override
    public List<Card> getAllCards() {
        return cards;
    }

    @Override
    public BigDecimal getCardBalance(String number) {
        return cards.stream()
                .filter(card -> card.getNumber().equals(number))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Cant get card balance"))
                .getBalance();
    }

    @Override
    public Card updateBalance(String number, BigDecimal value) {
        Card card = getCard(number);
        card.setBalance(card.getBalance().add(value));
        return card;
    }

    @Override
    public Card updateCardStatus(Integer cardId, Integer status) {
        Card card = cards.stream()
                .filter(card1 -> card1.getId().equals(cardId))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Cant update card status"));
        card.setStatus(status);
        return card;
    }

}
