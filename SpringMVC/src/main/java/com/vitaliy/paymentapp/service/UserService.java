package com.vitaliy.paymentapp.service;

import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {
    UserDto getUser(String login);

    UserDto getUserById(Integer id);

    UserDto createUser(UserRegistrationDto userRegistrationDTO);

    UserDto changeUserStatus(Integer status, String login);

    List<UserDto> getAllUsers();
}
