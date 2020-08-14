package com.coderby.myapp.hello.configuration;

import com.coderby.myapp.member.Person;
import com.coderby.myapp.hello.controller.HelloController;
import com.coderby.myapp.hello.service.HelloService;
import com.coderby.myapp.member.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.coderby.myapp" })
public class RootConfig {

	@Bean
	public HelloController helloController() {
		HelloController helloController = new HelloController();
		helloController.setHelloService(helloService());
		return helloController;

	}

	@Bean
	public HelloService helloService() {
		HelloService helloService = new HelloService();
		return helloService;
	}

	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("JinKyoung");
		person.setAge(30);

		return person;
	}

	@Bean
	public Customer customer() {
		Customer customer = new Customer();
		List<Object> lists = new ArrayList<Object>();
		Set<Object> sets = new HashSet<Object>();
		Map<String, Object> maps = new HashMap<String, Object>();
		Properties props = new Properties();

		Person listPerson = person();
		listPerson.setName("HyunJeong");
		listPerson.setAge(12);
		lists.add("1");
		lists.add(listPerson);
		customer.setLists(lists);

		Person setPerson = person();
		setPerson.setName("HyunJun");
		setPerson.setAge(11);
		sets.add("2");
		sets.add(setPerson);
		customer.setSets(sets);

		Person mapPerson = person();
		mapPerson.setName("HyunSoo");
		mapPerson.setAge(8);
		maps.put("Key1", "3");
		maps.put("Key2", person());
		maps.put("Key3", mapPerson);
		customer.setMaps(maps);

		props.setProperty("webmaster", "webmaster@coderby.com");
		props.setProperty("support", "support@coderby.com");
		customer.setProps(props);

		return customer;
	}
}
