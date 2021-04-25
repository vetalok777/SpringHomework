package com.vitaliy.paymentapp.controller.model;

import com.vitaliy.paymentapp.dto.CardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
public class CardModel extends RepresentationModel<CardModel> {

    private CardDto cardDto;
}
