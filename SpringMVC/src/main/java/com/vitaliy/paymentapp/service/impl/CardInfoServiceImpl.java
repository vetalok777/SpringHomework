package com.vitaliy.paymentapp.service.impl;

import com.vitaliy.paymentapp.dto.CardInfoDto;
import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.repository.CardRepository;
import com.vitaliy.paymentapp.service.CardInfoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardInfoServiceImpl implements CardInfoService {

    private CardRepository cardRepository;

    ModelMapper mapper;

    @Override
    public CardInfoDto getCardInfoByNumber(String number) {
        Card card = cardRepository.getCardByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        return mapper.map(card, CardInfoDto.class);
    }
}
