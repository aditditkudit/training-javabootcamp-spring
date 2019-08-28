package com.tavs.bootcamp.springboottrainingtelkom2019.di;

import org.springframework.stereotype.Component;

@Component
public class ClassA {
    private ClassB b;


    public ClassA(ClassB b) {
        this.b = b;
    }

    public ClassB getB() {
        return b;
    }

    public void setB(ClassB b) {
        this.b = b;
    }
}
