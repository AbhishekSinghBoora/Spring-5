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
		EmployeeServiceImpl service = null;
		AbstractApplicationContext ctx = (AbstractApplicationContext) SpringApplication.run(Client.class, args) ;
		service = (EmployeeServiceImpl) ctx.getBean("employeeService");
		List<EmployeeDTO> list = service.getAllCustomer();
		for(EmployeeDTO e : list) {
			System.out.format("EmpId: %d   Name: %s   Dept: %s", e.getEmpId(),e.getEmpName(),e.getDepartment());
			System.out.println();
		}
		ctx.close();

	}

}
