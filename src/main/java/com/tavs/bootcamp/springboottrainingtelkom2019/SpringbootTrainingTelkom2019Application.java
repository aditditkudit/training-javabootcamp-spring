package com.tavs.bootcamp.springboottrainingtelkom2019;

import com.tavs.bootcamp.springboottrainingtelkom2019.di.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootTrainingTelkom2019Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootTrainingTelkom2019Application.class, args);
		ClassF f = new ClassF();
		f.setName("Nama Gua Kudit");

		ClassE e = new ClassE();
		ClassD d = new ClassD(e, f);
		ClassC c = new ClassC(d);
		ClassB b = new ClassB(c, d);
		ClassA a = new ClassA(b);

		System.out.println("Nilau Value dari F= " + a.getB().getC().getD().getF().getName());

	}

}
