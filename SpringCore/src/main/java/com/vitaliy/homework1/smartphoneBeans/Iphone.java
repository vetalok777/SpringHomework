package com.vitaliy.homework1.smartphoneBeans;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Primary
public class Iphone implements Processor {

    private static final String NAME = "Iphone";

    @Override
    public String getProcessor() {
        return NAME + " is working on Apple  Bionic";
    }
}
