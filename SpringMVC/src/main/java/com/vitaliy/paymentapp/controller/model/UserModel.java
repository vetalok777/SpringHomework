package com.vitaliy.paymentapp.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vitaliy.paymentapp.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;



@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
public class UserModel extends RepresentationModel<UserModel> {


    @JsonUnwrapped
    private UserDto userDto;


}
