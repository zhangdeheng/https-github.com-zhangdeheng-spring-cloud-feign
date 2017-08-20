package com.example.springbootdemo.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainiersoft.helloservice.api.entity.User;
import com.rainiersoft.helloservice.api.service.HelloService;
@RestController
public class RefactorHelloController implements HelloService{

	public RefactorHelloController() {
	}

	@Override
	public String hello(@RequestParam String name){
		return "Hello"+name;
	}
	@Override
	public User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
		return new User(name,age);
	}
	@Override
	public String hello(@RequestBody User user){
		return "Hello "+user.getName()+","+user.getAge();
	}

}
