package com.coderby.myapp.hello.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.coderby.myapp" })
public class RootConfig {
	/**
	 * @Configuration class 방식에서는 
	 * AOP 설정이 기본적으로 Annotation으로 이루어진다.
	 * 3.3_SpringAOPAnnotation 예제로 바로 넘어갑니다.
	 */
}
