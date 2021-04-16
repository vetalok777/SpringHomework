package com.vitaliy.paymentapp.mapper;

import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.model.User;
import org.modelmapper.AbstractConverter;

public class UserMapper extends AbstractConverter<User, UserDto> {
    @Override
    protected UserDto convert(User user) {
        return null;
    }
}
