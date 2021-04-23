package com.vitaliy.paymentapp.repository.impl;

import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.model.User;
import com.vitaliy.paymentapp.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public User getUser(String login) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get user"));
    }

    @Override
    public User getUserById(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get user"));
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User changeUserStatus(Integer status, String login) {
        User user = getUser(login);
        user.setStatus(status);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }


}
