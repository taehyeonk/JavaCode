package com.coderby.myapp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.coderby.myapp.hello.service.IHelloService;
import com.coderby.myapp.util.HelloLog;

@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("helloService")
	IHelloService helloService;
		
	public void hello(String name) {
//		HelloLog.log();
		System.out.println("HelloController : " + helloService.sayHello(name));
//		HelloLog.log();
	}
}