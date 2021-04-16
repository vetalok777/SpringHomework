package com.vitaliy.homework2.beans;

import com.vitaliy.homework2.Type;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("Inside BeanPostProcessor.postProcessBeforeInitialization " + beanName);
        if (bean instanceof Type) {
            if (((Type) bean).getName() != null && ((Type) bean).getValue() >= 0) {
                System.out.println(beanName + " -> Validation is successful");
            } else {
                System.out.println(beanName + " -> Validation is failed");
            }
        }
        return bean;

    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Inside BeanPostProcessor.postProcessAfterInitialization " + beanName);
        return bean;
    }
}
