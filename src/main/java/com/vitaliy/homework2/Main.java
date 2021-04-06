package com.vitaliy.homework2;


import com.vitaliy.homework2.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        for (String bean : ctx.getBeanDefinitionNames()) {
            System.out.println(bean);
        }

        //Getting bean with lazy annotation
        ctx.getBean("getBeanF");
        ctx.close();
    }
}

