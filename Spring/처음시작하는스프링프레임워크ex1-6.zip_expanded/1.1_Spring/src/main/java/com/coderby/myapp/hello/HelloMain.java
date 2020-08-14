package com.coderby.myapp.hello;

import com.coderby.myapp.hello.controller.HelloController;
import com.coderby.myapp.hello.service.HelloService;
import com.coderby.myapp.hello.service.IHelloService;

public class HelloMain {
	public static void main(String[] args) {
		IHelloService helloService = new HelloService();
		HelloController controller = new HelloController(helloService);
		controller.setHelloService(helloService);
		controller.hello("홍길동");
	}
}