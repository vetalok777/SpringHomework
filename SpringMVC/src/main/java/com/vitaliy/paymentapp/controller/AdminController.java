package com.vitaliy.paymentapp.controller;

import com.vitaliy.paymentapp.dto.AdminDto;
import com.vitaliy.paymentapp.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/{login}")
    @ResponseStatus(HttpStatus.OK)
    public AdminDto getAdmin(@PathVariable String login) {
        log.info("Get admin: " + login);
        return adminService.getAdmin(login);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AdminDto createAdmin(@RequestBody AdminDto adminDto) {
        log.info("Create admin: " + adminDto);
        return adminService.createAdmin(adminDto);
    }
}
