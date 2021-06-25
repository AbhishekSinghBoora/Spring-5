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
//		EmployeeDTO emp = new EmployeeDTO(102, "John", "FDC");
//		service1.insert(emp);
//		List<EmployeeDTO> list1 = service1.getAllCustomer();
//
//		for(EmployeeDTO e : list1) {
//			System.out.format("EmpId: %d   Name: %s   Dept: %s", e.getEmpId(),e.getEmpName(),e.getDepartment());
//			System.out.println();
//		}
		
		service1.delete(101);
		
//		ctx.close();

	}

}
