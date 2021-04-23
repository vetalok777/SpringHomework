package com.vitaliy.paymentapp.repository.impl;

import com.vitaliy.paymentapp.exception.ResourceNotFoundException;
import com.vitaliy.paymentapp.model.Admin;
import com.vitaliy.paymentapp.model.User;
import com.vitaliy.paymentapp.repository.AdminRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminRepositoryImpl implements AdminRepository {
    private List<Admin> admins = new ArrayList<>();

    @Override
    public Admin getAdmin(String login) {
        return admins.stream()
                .filter(admin -> admin.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cant get admin"));

    }

    @Override
    public Admin createAdmin(Admin admin) {
        admins.add(admin);
        return admin;
    }


}
