package com.rainierSoft.component;

import com.rainierSoft.service.HelloService;
import com.rainiersoft.helloservice.api.entity.User;

public class HelloServiceFallback implements HelloService {

	@Override
	public String hello() {
		return "error";
	}

	@Override
	public String hello(String name) {
		return "error";
	}

	@Override
	public User hello(String name, Integer age) {
		return new User("未知",0);
	}

	@Override
	public String hello(User user) {
		return "error";
	}

}
