package com.vitaliy.paymentapp.service;

import com.vitaliy.paymentapp.dto.AdminDto;

public interface AdminService {
    AdminDto getAdmin(String login);
    AdminDto createAdmin(AdminDto adminDto);
}
