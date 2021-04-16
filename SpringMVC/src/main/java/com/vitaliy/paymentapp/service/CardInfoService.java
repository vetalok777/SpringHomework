package com.vitaliy.paymentapp.service;


import com.vitaliy.paymentapp.dto.CardInfoDto;

public interface CardInfoService {

    public CardInfoDto getCardInfoByNumber(String number);
}
