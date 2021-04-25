package com.vitaliy.paymentapp.controller.assembler;

import com.vitaliy.paymentapp.controller.UserController;
import com.vitaliy.paymentapp.controller.model.UserModel;
import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.dto.UserRegistrationDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link getUser = linkTo(methodOn(UserController.class).getUser(entity.getLogin())).withRel("get");
        Link getAllUsers = linkTo(methodOn(UserController.class).getAllUsers()).withRel("getAll");
        userModel.add(getUser);
        userModel.add(getAllUsers);
        return userModel;
    }


}
