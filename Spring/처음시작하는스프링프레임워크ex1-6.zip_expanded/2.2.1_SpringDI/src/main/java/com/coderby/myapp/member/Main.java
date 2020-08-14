package com.coderby.myapp.member;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.coderby.myapp.hello.configuration.RootConfig;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
//		Customer cust = context.getBean(Customer.class);
//		System.out.println(cust);
		Person person1 = context.getBean(Person.class);
		Person person2 = context.getBean(Person.class);
		System.out.println("person1.name :" + person1.getName());
		System.out.println("person1.age :" + person1.getAge());
		System.out.println(person1 == person2);
		context.close();
	}
}
