package com.vitaliy.paymentapp.service.impl;

import com.vitaliy.paymentapp.dto.CardDto;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.repository.CardRepository;
import com.vitaliy.paymentapp.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public CardDto getCard(String number) {
        Card card = cardRepository.getCard(number);
        return mapCardToCardDto(card);
    }

    @Override
    public CardDto getCardByName(String name) {
        Card card = cardRepository.getCardByName(name);
        return mapCardToCardDto(card);
    }

    @Override
    public List<CardDto> getAllCards() {
        return cardRepository.getAllCards().stream()
                .map(this::mapCardToCardDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardDto updateCardBalance(String number, BigDecimal value) {
        Card card = cardRepository.updateBalance(number, value);
        return mapCardToCardDto(card);
    }

    @Override
    public CardDto updateCardStatus(Integer cardId, Integer status) {
        Card card = cardRepository.updateCardStatus(cardId, status);
        return mapCardToCardDto(card);
    }

    @Override
    public CardDto createCard(CardDto cardDto) {
        Card card = mapCardDtoToCard(cardDto);
        card = cardRepository.createCard(card);
        return mapCardToCardDto(card);
    }

    private CardDto mapCardToCardDto(Card card) {
        return CardDto.builder()
                .status(card.getStatus())
                .number(card.getNumber())
                .name(card.getName())
                .balance(card.getBalance())
                .build();
    }

    private Card mapCardDtoToCard(CardDto cardDto) {
        return Card.builder()
                .status(cardDto.getStatus())
                .number(cardDto.getNumber())
                .name(cardDto.getName())
                .balance(cardDto.getBalance())
                .build();
    }
}
