package com.vitaliy.homework1.otherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructBean {


    private OtherBeanA otherBeanA;


    @Autowired
    public ConstructBean(@Qualifier("otherBeanA") OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }


}
