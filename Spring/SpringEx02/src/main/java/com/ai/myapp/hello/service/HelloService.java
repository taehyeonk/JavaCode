package com.ai.myapp.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

	@Override
	public String sayHello(String hello) {
		System.out.println("name : " + hello);
		return "name : " + hello;	
	}
}
