package com.vitaliy.paymentapp.repository;

import com.vitaliy.paymentapp.model.User;

import java.util.List;

public interface UserRepository {

    User getUser(String login);

    User getUserById(Integer id);

    User createUser(User user);

    User changeUserStatus(Integer status, String login);

    List<User> getAllUsers();
}
