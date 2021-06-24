package com.infy.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.infy.repository.EmployeeRepositoryImpl;
import com.infy.service.EmployeeServiceImpl;

@Configuration
@ComponentScan(basePackages="com.infy")
public class SpringConfiguration {
//	@Bean
//	public EmployeeRepositoryImpl employeeRepository() {
//		return new EmployeeRepositoryImpl();
//	}
//	
//	@Bean
//	public EmployeeServiceImpl employeeService() {
//		EmployeeServiceImpl impl = new EmployeeServiceImpl();
//		impl.setRepository(employeeRepository());
//		return impl;
//	}

}
