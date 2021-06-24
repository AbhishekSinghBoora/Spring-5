package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.service.EmployeeServiceImpl;
@SpringBootApplication
public class Client {

	public static void main(String[] args) {
		EmployeeServiceImpl service = null;
		AbstractApplicationContext ctx = (AbstractApplicationContext) SpringApplication.run(Client.class, args) ;
		service = (EmployeeServiceImpl) ctx.getBean("employeeService");
		System.out.println(service);
		ctx.close();

	}

}
