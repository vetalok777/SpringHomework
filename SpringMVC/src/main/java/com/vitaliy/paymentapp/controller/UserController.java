package com.vitaliy.paymentapp.controller;

import com.vitaliy.paymentapp.dto.UserDto;
import com.vitaliy.paymentapp.dto.UserRegistrationDto;
import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping("/login/{login}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable @Valid @NotNull(message = "Field must be not null") @Email
            (message = "Should be valid email")
                                   String login) {
        log.info("Get user: " + login);
        return userService.getUser(login);
    }

    @GetMapping("/allUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers() {
        log.info("Get all users: " + userService.getAllUsers());
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable @Valid @NotNull(message = "Field must be not null")
                               @Pattern(regexp = "\\d+", message = "Should be valid id") Integer id) {
        log.info("Get user by id: " + id);
        return   userService.getUserById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Valid UserRegistrationDto userDto) {
        log.info("Create user: " + userDto);
        return userService.createUser(userDto);
    }

    @PutMapping("/changeStatus/{status}{login}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto changeStatus(@PathVariable @Valid
                                @Pattern(regexp = "[0-1]", message = "Should be digit 0 or 1")
                                        Integer status,
                                @Valid @PathVariable @NotNull(message = "Field must be not null") @Email
                                        (message = "Should be valid email") String login) {
        log.info("Change user status: " + status + ", " + login);
        return userService.changeUserStatus(status, login);
    }
}
