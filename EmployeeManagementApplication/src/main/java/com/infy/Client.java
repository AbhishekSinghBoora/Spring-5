package com.infy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.dto.EmployeeDTO;
import com.infy.service.EmployeeServiceImpl;
import com.infy.util.SpringConfiguration;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		EmployeeServiceImpl service = (EmployeeServiceImpl) ctx.getBean("employeeService");
		System.out.println(service);
		ctx.close();

	}

}
