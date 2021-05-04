package com.vitaliy.paymentapp.mapper;

import com.vitaliy.paymentapp.dto.CardDto;
import com.vitaliy.paymentapp.dto.CardInfoDto;
import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.model.User;
import com.vitaliy.paymentapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardInfoDtoMapper extends AbstractConverter<Card, CardInfoDto> {

    private UserRepository userRepository;

    @Override
    protected CardInfoDto convert(final Card card) {
        User user = userRepository.findById(card.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));


        return CardInfoDto.builder()
                .card(CardDto.builder()
                        .name(card.getName())
                        .number(card.getNumber())
                        .balance(card.getBalance())
                        .status(card.getStatus())
                        .build())
                .user(UserDto.builder()
                        .firstName(user.getFirstName())
                        .login(user.getLogin())
                        .build())
                .build();
    }
}
