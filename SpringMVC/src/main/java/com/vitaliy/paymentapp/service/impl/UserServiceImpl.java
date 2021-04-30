package com.vitaliy.paymentapp.service.impl;

import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.dto.UserRegistrationDto;
import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
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
        User user = userRepository.getUserByLogin(login)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserRegistrationDto userRegistrationDTO) {
        User user = mapUserRegistrationDtoToUser(userRegistrationDTO);
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto changeUserStatus(boolean status, String login) {
        User user = userRepository.getUserByLogin(login)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setStatus(status);
        userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
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
