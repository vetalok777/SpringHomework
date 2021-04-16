package com.vitaliy.paymentapp.mapper;

import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.model.User;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper extends AbstractConverter<UserDto, User> {
    @Override
    protected User convert(final UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .login(userDto.getLogin())
            //    .password(userDto.getPassword())
                .build();
    }
}
