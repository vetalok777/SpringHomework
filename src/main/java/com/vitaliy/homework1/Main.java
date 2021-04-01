package com.vitaliy.homework1;


import com.vitaliy.homework1.config.AppConfig1;

import com.vitaliy.homework1.config.AppConfig2;
import com.vitaliy.homework1.config.OtherBeansConfig;
import com.vitaliy.homework1.config.SmartphonesConfig;
import com.vitaliy.homework1.smartphoneBeans.GeneralBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        //Initialization of config files
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig2.class);
        ApplicationContext context3 = new AnnotationConfigApplicationContext(OtherBeansConfig.class);
        ApplicationContext context4 = new AnnotationConfigApplicationContext(SmartphonesConfig.class);
        System.out.println("----------Scanning beans1 package----------");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("----------Scanning beans2 and beans3 package----------");
        for (String beanDefinitionName : context2.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("----------Scanning otherBeans package----------");
        //Beans with constructor, setter, and field injection
        for (String beanDefinitionName : context3.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("--------Scanning smartphonesBeans package--------");

        //Beans that realized interface
        for (String beanDefinitionName : context3.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        //Using collections of created beans and printing them
        context4.getBean(GeneralBean.class).printProcessors();
    }
}
