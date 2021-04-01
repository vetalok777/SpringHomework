package com.vitaliy.homework1.otherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldBean {
    @Autowired
    private OtherBeanC otherBeanC;
}
