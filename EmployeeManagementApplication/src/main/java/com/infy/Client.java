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
		List<EmployeeDTO> list1 = service1.getAllCustomer();
		System.out.println("--------------------------------------------------------");
		System.out.println("Bean service1 output: Number of employees = "+list1.size());
//		for(EmployeeDTO e : list1) {
//			System.out.format("EmpId: %d   Name: %s   Dept: %s", e.getEmpId(),e.getEmpName(),e.getDepartment());
//			System.out.println();
//		}
		EmployeeDTO emp = new EmployeeDTO(102, "John", "FDC");
		service1.insert(emp);
		List<EmployeeDTO> list2 = service1.getAllCustomer();
		System.out.println("Bean service1 output after inserting employee: Number of employees = "+list2.size());
		
		EmployeeServiceImpl service2 = (EmployeeServiceImpl) ctx.getBean("employeeService");
		List<EmployeeDTO> list3 = service2.getAllCustomer();
//		for(EmployeeDTO e : list3) {
//			System.out.format("EmpId: %d   Name: %s   Dept: %s", e.getEmpId(),e.getEmpName(),e.getDepartment());
//			System.out.println();
//		}
		System.out.println("\nBean service2 output: Number of employees = "+list3.size());
		System.out.println("\nComparing two service beans of scope(prototype) :");
		System.out.print(service1==service2);

		
		ctx.close();

	}

}
