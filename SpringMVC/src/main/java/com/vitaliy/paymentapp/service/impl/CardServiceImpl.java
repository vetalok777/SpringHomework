package com.vitaliy.paymentapp.service.impl;

import com.vitaliy.paymentapp.dto.CardDto;
import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.model.User;
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
        Card card = cardRepository.getCardByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        return mapCardToCardDto(card);
    }

    @Override
    public CardDto getCardByName(String name) {
        Card card = cardRepository.getCardByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        return mapCardToCardDto(card);
    }

    @Override
    public List<CardDto> getAllCards() {
        return cardRepository.findAll().stream()
                .map(this::mapCardToCardDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardDto updateCardBalance(String number, BigDecimal value, String action) throws Exception {
        Card card = cardRepository.getCardByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        if (action.equals("add")) {
            card.setBalance(card.getBalance().add(value));
        } else if (action.equals("subtract")) {
            card.setBalance(card.getBalance().subtract(value));
        } else {
            throw new Exception("There is no action you typed");
        }
        return mapCardToCardDto(card);
    }

    @Override
    public CardDto updateCardStatus(Integer cardId, boolean status) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        card.setStatus(status);
        return mapCardToCardDto(card);
    }

    @Override
    public CardDto createCard(CardDto cardDto, User user) {
        Card card = mapCardDtoToCard(cardDto);;
        card.setUser(user);
        card = cardRepository.save(card);
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
