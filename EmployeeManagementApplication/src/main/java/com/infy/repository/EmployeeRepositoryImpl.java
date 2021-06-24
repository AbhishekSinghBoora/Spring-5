package com.infy.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.infy.dto.EmployeeDTO;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository{

	List<EmployeeDTO> employees = null;
	
	@PostConstruct
	public void initializer() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(101);
		employeeDTO.setEmpName("Jack");
		employeeDTO.setDepartment("ETA");
		employees = new ArrayList<EmployeeDTO>();
		employees.add(employeeDTO);
		
	}
	
	// add the new employee to employees list
	public void insertEmployee(EmployeeDTO emp) {
		employees.add(emp);
		
	}

	// remove the employee form the employees list using employee id
	public void removeEmployee(int empId) {
		employees.remove(empId);
		
	}

	// return a list of employees
	public List<EmployeeDTO> fetchCustomer() {
		return employees;
	}
	

}
