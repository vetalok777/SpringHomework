package com.vitaliy.homework2.beans;

import org.springframework.beans.BeansException;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;



public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("getBeanB");
        bd.setInitMethodName("init");
    }

}

