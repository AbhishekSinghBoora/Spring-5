package com.infy;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infy.domain.Employee;
import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;
import com.infy.service.EmployeeService;
import com.infy.service.EmployeeServiceImpl;
@SpringBootApplication
public class Client implements CommandLineRunner{
	static Logger logger = LogManager.getLogger(Client.class);
	@Autowired
	ApplicationContext context;
	@Autowired
	EmployeeService service;
	@Autowired
	EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeDTO e1 = new EmployeeDTO(101, "Rohan", "ETA", "Delhi", null);
		EmployeeDTO e2 = new EmployeeDTO(102, "Suraj", "FDM", "Luknow", null);
		EmployeeDTO e3 = new EmployeeDTO(103, "Rohan", "DGTL", "Bnaras", null);
		EmployeeDTO e4 = new EmployeeDTO(104, "Vikas", "FDM", "Kolkata", null);
		EmployeeDTO e5 = new EmployeeDTO(105, "Ajay", "DGTL", "Mysore", null);
		EmployeeDTO e6 = new EmployeeDTO(105, "Kartik", "DPM", "Banglore", null);
		
		service.addEmployee(e1);
		service.addEmployee(e2);
		service.addEmployee(e3);
		service.addEmployee(e4);
		service.addEmployee(e5);
		service.addEmployee(e6);
		System.out.println("Employees are successfully added.");
		
		// pagination and sorting operations
		System.out.println("\n****************");
		int k = (int) (repository.count()/3);
		for(int i=0; i<=k; i++) {
			Pageable pageable = PageRequest.of(i, 3);
			
			System.out.println("Records are: ");
			Iterable<Employee> emp = service.findAll(pageable);
			
			for(Employee e: emp) {
				System.out.println(e);
			}
		}
		
		System.out.println("Sorted records...");
		Iterable<Employee> emp = service.findAll(Sort.by(Sort.Direction.DESC, "empName"));
		for(Employee e: emp) {
			System.out.println(e);
		}
		
		System.out.println("\n****************");
		
		
		System.out.println("Enter the employee id of the employee which has to be deleted.");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		service.removeEmployee(id);
		logger.info("Employee removed successfully.");
		
		logger.info("Let's print the details of an employee");
		System.out.println("Enter the emp id of employee which details you want to print.");
		int id1 = sc.nextInt();
		EmployeeDTO dto = service.searchEmployee(id1);
		logger.info("Employee Details");
		logger.info("Id: "+dto.getEmpId()
				+ "\nName: "+dto.getEmpName()
				+ "\nDepartment: "+dto.getDepartment()
				+ "\nBase Location: "+dto.getBaseLocation()
				+ "\nAddress: "+dto.getAddress());
		
		logger.info("Let's update the department of an employee");
		System.out.println("Enter the emp id of the employee which department has to be updated.");
		int id2 = sc.nextInt();
		System.out.println("Enter the new department allocated");
		String newDept = sc.next();
		service.editEmployee(id2, newDept);
		sc.close();
		
	}

}
