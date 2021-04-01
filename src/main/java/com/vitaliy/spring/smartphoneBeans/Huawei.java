package com.vitaliy.spring.smartphoneBeans;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Qualifier("huawei")
public class Huawei implements Processor {

    private static final String NAME = "Huawei";


    @Override
    public String getProcessor() {
        return NAME + " is working on Kirin";
    }
}
