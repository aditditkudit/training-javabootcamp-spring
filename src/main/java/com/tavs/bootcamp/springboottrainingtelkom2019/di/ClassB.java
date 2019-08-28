package com.tavs.bootcamp.springboottrainingtelkom2019.di;

import org.springframework.stereotype.Component;

@Component
public class ClassB {
    private ClassC c;
    private ClassD d;

    public ClassB(ClassC c, ClassD d) {
        this.c = c;
        this.d = d;
    }

    public ClassC getC() {
        return c;
    }

    public void setC(ClassC c) {
        this.c = c;
    }

    public ClassD getD() {
        return d;
    }

    public void setD(ClassD d) {
        this.d = d;
    }
}
