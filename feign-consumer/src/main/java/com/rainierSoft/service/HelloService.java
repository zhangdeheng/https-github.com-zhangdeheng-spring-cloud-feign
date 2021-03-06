package com.rainierSoft.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rainierSoft.component.HelloServiceFallback;
import com.rainierSoft.config.FullLogConfiguration;
import com.rainiersoft.helloservice.api.entity.User;
//spring cloud feign 中除了引入了用于客户端负载均衡的spring cloud Ribbon 之外，还引入了服务保护与容错的工具Hystrix
//@FeignClient(name="hello-service",fallback=HelloServiceFallback.class)//降级
//@FeignClient(name="hello-service",configuration=DisableHystrixConfiguration.class)//禁用hystrix
@FeignClient(name="hello-service",configuration=FullLogConfiguration.class,fallback=HelloServiceFallback.class)//开启日志
public interface HelloService extends com.rainiersoft.helloservice.api.service.HelloService{
	@RequestMapping("/hello")
	String hello();
	@RequestMapping(value="/hello4",method=RequestMethod.GET)
	String hello(@RequestParam("name") String name);
	@RequestMapping(value="/hello5", method=RequestMethod.GET)
	User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	@RequestMapping(value="/hello6",method=RequestMethod.POST)
	String hello(@RequestBody User user);
}
