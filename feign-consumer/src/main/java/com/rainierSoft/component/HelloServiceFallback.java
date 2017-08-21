package com.rainierSoft.component;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.rainierSoft.service.HelloService;
import com.rainiersoft.helloservice.api.entity.User;

public class HelloServiceFallback implements HelloService {

	@Override
	public String hello() {
		return "error";
	}

	@Override
	public String hello(@RequestParam("name") String name) {
		return "error";
	}

	@Override
	public User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age) {
		return new User("未知",0);
	}

	@Override
	public String hello(@RequestBody User user) {
		return "error";
	}

}
