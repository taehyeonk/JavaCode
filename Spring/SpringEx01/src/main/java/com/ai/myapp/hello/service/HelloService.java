package com.ai.myapp.hello.service;

public class HelloService implements IHelloService {

	@Override
	public String sayHello(String hello) {
		System.out.println("name : " + hello);
		return "name : " + hello;	
	}
}
