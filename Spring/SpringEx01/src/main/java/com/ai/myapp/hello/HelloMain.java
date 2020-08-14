package com.ai.myapp.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.myapp.hello.controller.HelloController;

public class HelloMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		HelloController controller = (HelloController)context.getBean("helloController");
		
		controller.hello("Son");

	}

}
