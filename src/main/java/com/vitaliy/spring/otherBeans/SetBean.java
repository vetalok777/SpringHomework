package com.vitaliy.spring.otherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetBean {


    private OtherBeanB otherBeanB;

    @Autowired
    public void setBeanB(OtherBeanB beanB) {
        this.otherBeanB = beanB;
    }


}
