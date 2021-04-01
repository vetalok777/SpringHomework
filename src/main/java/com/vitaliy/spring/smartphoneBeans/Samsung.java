package com.vitaliy.spring.smartphoneBeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@Qualifier("samsung")
public class Samsung implements Processor {

    private static final String NAME = "Samsung";


    @Override
    public String getProcessor() {
        return NAME + " is working on Snapdragon";
    }
}
