package com.ai.myapp.hello.controller;

import org.springframework.stereotype.Controller;

import com.ai.myapp.hello.service.IHelloService;

@Controller
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
