package com.vitaliy.paymentapp.service.impl;

import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.dto.UserRegistrationDto;
import com.vitaliy.paymentapp.model.User;
import com.vitaliy.paymentapp.repository.UserRepository;
import com.vitaliy.paymentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        User user = userRepository.getUser(login);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.getUserById(id);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserRegistrationDto userRegistrationDTO) {
        User user = mapUserRegistrationDtoToUser(userRegistrationDTO);
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto changeUserStatus(Integer status, String login) {
        User user = userRepository.changeUserStatus(status, login);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }


    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .login(user.getLogin())
                .build();
    }

    private User mapUserRegistrationDtoToUser(UserRegistrationDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
    }
}
