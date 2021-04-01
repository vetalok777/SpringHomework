package com.vitaliy.homework1.smartphoneBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralBean {

    private List<Processor> processors;

    @Autowired
    public GeneralBean(List<Processor> processors) {
        this.processors = processors;
    }

    public void printProcessors() {
        for (Processor processor : processors) {
            System.out.println(processor.getProcessor());
        }
    }
}
