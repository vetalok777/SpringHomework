package com.vitaliy.paymentapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardInfoDto {

    private CardDto card;
    private UserDto user;

}
