package com.rainierSoft.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainiersoft.helloservice.api.entity.User;
import com.rainiersoft.helloservice.api.service.HelloService;

@RestController
public class ConsumerController {
	@Autowired
	HelloService helloService;
	@RequestMapping(value="/feign-consumer2",method=RequestMethod.GET)
	public String helloConsumer2(){
		StringBuilder sb=new StringBuilder();
		sb.append(helloService.hello("zhangdeheng")).append("\n");
		sb.append(helloService.hello("zhangdeheng", 18)).append("\n");
		sb.append(helloService.hello(new User("zhangdeheng", 18))).append("\n");
		return sb.toString();
	}
	@RequestMapping(value="/feign-consumer3",method=RequestMethod.GET)
	public String helloConsumer3(){
		StringBuilder sb=new StringBuilder();
		sb.append(helloService.hello("zhangdeheng")).append("\n");
		sb.append(helloService.hello("zhangdeheng", 18)).append("\n");
		sb.append(helloService.hello(new User("zhangdeheng", 18))).append("\n");
		return sb.toString();
	}
}
