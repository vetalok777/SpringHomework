package com.vitaliy.paymentapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@Entity
@Table(name = "user")
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "login", unique = true, length = 45, nullable = false)
    private String login;
    @Column(name = "password", length = 45, nullable = false)
    private String password;
    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;
    @Column(name = "status", nullable = false, columnDefinition = "boolean default true")
    private boolean status;
}
