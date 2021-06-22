package com.infy.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infy.service.CustomerServiceImpl;

@Configuration
public class SpringConfiguration {
	@Bean // creating a bean
	public CustomerServiceImpl customerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.setCount(10); // dependency injection through setter method
		return customerService;
	}
}
