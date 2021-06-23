package com.infy.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infy.service.EmployeeServiceImpl;

@Configuration
public class SpringConfiguration {
	@Bean
	public EmployeeServiceImpl employeeService() {
		return new EmployeeServiceImpl();
	}

}
