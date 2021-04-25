package com.vitaliy.paymentapp.controller.assembler;


import com.vitaliy.paymentapp.controller.CardController;
import com.vitaliy.paymentapp.controller.UserController;
import com.vitaliy.paymentapp.controller.model.CardModel;
import com.vitaliy.paymentapp.controller.model.UserModel;
import com.vitaliy.paymentapp.dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CardAssembler extends RepresentationModelAssemblerSupport<CardDto, CardModel> {


    public CardAssembler() {
        super(CardController.class, CardModel.class);
    }

    @Override
    public CardModel toModel(CardDto entity) {
        CardModel cardModel = new CardModel(entity);

        Link getCard = linkTo(methodOn(CardController.class).getCard(entity.getNumber())).withRel("get");
        Link getCardByName = linkTo(methodOn(CardController.class).getCardByName(entity.getName()))
                .withRel("getByName");
        Link getAllCards = linkTo(methodOn(CardController.class).getAllCards()).withRel("getAll");
        cardModel.add(getCard, getAllCards, getCardByName);
        return cardModel;
    }
}
