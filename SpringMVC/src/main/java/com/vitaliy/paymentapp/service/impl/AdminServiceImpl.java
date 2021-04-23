package com.vitaliy.paymentapp.service.impl;

import com.vitaliy.paymentapp.dto.AdminDto;
import com.vitaliy.paymentapp.dto.CardDto;
import com.vitaliy.paymentapp.model.Admin;
import com.vitaliy.paymentapp.model.Card;
import com.vitaliy.paymentapp.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements com.vitaliy.paymentapp.service.AdminService {

    private final AdminRepository adminRepository;


    @Override
    public AdminDto getAdmin(String login) {
        Admin admin = adminRepository.getAdmin(login);
        return mapAdminToAdminDto(admin);
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = mapAdminDtoToAdmin(adminDto);
        admin = adminRepository.createAdmin(admin);
        return mapAdminToAdminDto(admin);
    }


    private AdminDto mapAdminToAdminDto(Admin admin) {
        return AdminDto.builder()
                .login(admin.getLogin())
                .password(admin.getPassword())
                .build();
    }

    private Admin mapAdminDtoToAdmin(AdminDto adminDto) {
        return Admin.builder()
                .login(adminDto.getLogin())
                .password(adminDto.getPassword())
                .build();
    }

}
