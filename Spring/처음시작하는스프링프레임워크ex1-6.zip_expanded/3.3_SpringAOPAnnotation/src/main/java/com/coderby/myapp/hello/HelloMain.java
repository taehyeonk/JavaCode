package com.coderby.myapp.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coderby.myapp.hello.configuration.RootConfig;
import com.coderby.myapp.hello.controller.HelloController;

public class HelloMain {
	public static void main(String[] args) {

//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("root-config.xml");
		HelloController controller = context.getBean("helloController", HelloController.class);
		controller.hello("Eric");
		System.out.println();
		controller.goodbye("Dan");
		context.close();
	}
}