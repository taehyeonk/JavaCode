package com.coderby.myapp.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coderby.myapp.hello.configuration.RootConfig;
import com.coderby.myapp.hello.controller.HelloController;

public class HelloMain {
	public static void main(String[] args) {
		// class로 할 때
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
//		HelloController controller = context.getBean("helloController", HelloController.class);
		
		//xml로 할 때
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("root-config.xml");
		HelloController controller = (HelloController)context.getBean("helloController");
		
		controller.hello("Spring DI !!!");
		context.close();
	}
}