package com.tavs.bootcamp.springboottrainingtelkom2019;

import com.tavs.bootcamp.springboottrainingtelkom2019.di.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootTrainingTelkom2019Application {

	public static void main(String[] args) {

//		Automatic Injection
		ApplicationContext context = SpringApplication.run(SpringbootTrainingTelkom2019Application.class, args);

		ClassA x = context.getBean(ClassA.class);
		System.out.println(" Hasil dari automatic injection adalah= " + x.getB().getD().getF().getName());

//		Manual Injection
		ClassF f = new ClassF();
		f.setName("Nama Gua Kudit");

		ClassE e = new ClassE();
		ClassD d = new ClassD(e, f);
		ClassC c = new ClassC(d);
		ClassB b = new ClassB(c, d);
		ClassA a = new ClassA(b);

		System.out.println("Nilau Value dari F= " + a.getB().getD().getF().getName());

	}

}
