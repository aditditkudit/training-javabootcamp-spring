package com.tavs.bootcamp.springboottrainingtelkom2019.di;

import org.springframework.stereotype.Component;

@Component
public class ClassD {
    private ClassE e;
    private ClassF f;

    public ClassD(ClassE e, ClassF f) {
        this.e = e;
        this.f = f;
    }

    public ClassE getE() {
        return e;
    }

    public void setE(ClassE e) {
        this.e = e;
    }

    public ClassF getF() {
        return f;
    }

    public void setF(ClassF f) {
        this.f = f;
    }
}
