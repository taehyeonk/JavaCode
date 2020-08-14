package com.coderby.myapp.hello.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.coderby.myapp" })
public class RootConfig {

}
