package com.vitaliy.paymentapp.service;

import com.vitaliy.paymentapp.dto.CardInfoDto;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardInfoServiceImpl implements CardInfoService {

    private CardRepository cardRepository;

    ModelMapper mapper;

    @Override
    public CardInfoDto getCardInfoByNumber(String number) {
        Card card = cardRepository.getCard(number);
        return mapper.map(card, CardInfoDto.class);
    }
}
