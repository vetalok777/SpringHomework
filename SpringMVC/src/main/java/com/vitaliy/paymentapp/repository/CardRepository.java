package com.vitaliy.paymentapp.repository;

import com.vitaliy.paymentapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> getCardByNumber(String number);
    Optional<Card> getCardByName(String name);
}
