package com.infy;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.dto.EmployeeDTO;
import com.infy.service.EmployeeServiceImpl;
@SpringBootApplication
public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = (AbstractApplicationContext) SpringApplication.run(Client.class, args) ;
		EmployeeServiceImpl service1 = (EmployeeServiceImpl) ctx.getBean("employeeService");
		service1.getAllEmployees();		
		ctx.close();

	}

}
