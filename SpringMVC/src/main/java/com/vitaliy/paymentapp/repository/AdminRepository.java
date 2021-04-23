package com.vitaliy.paymentapp.repository;

import com.vitaliy.paymentapp.model.Admin;

public interface AdminRepository {
    Admin getAdmin(String login);
    Admin createAdmin(Admin admin);
}
