package com.rainierSoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import feign.Feign;

public class DisableHystrixConfiguration {
	@Bean
	@Scope("prototype")//针对某个服务客户端关闭Hystrix支持
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}

}
