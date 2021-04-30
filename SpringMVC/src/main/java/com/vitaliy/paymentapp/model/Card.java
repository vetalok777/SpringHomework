package com.vitaliy.paymentapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "card")
@RequiredArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "card_name", length = 45, nullable = false)
    private String name;
    @Column(name = "card_number", unique = true, length = 16, nullable = false)
    private String number;
    @Column(name = "card_balance", nullable = false, columnDefinition = "Decimal default 0.0")
    private BigDecimal balance;
    @Column(name = "card_status", nullable = false, columnDefinition = "boolean default true")
    private boolean status;
    
    private Integer userId;
}
