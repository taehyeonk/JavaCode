package com.ai.myapp.hello.controller;

import com.ai.myapp.hello.service.IHelloService;

public class HelloController {
	IHelloService helloService;

	public HelloController() {
		
	}

	public HelloController(IHelloService helloServcie) {
		this.helloService = helloServcie;
	}
	
	public void hello(String name) {
		System.out.println("HelloController : " + helloService.sayHello(name));
	}
}