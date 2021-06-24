package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;

@Service("employeeService")
@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeDAO;
	
	public void insert(EmployeeDTO emp) {
		employeeDAO.insertEmployee(emp);	
		System.out.println("Employee with EmpId "+emp.getEmpId()+" inserted successfully");
	}

	public void delete(int empId) {
		employeeDAO.removeEmployee(empId);	
		System.out.println("Employee with EmpId "+empId+" deleted successfully");
	}
	
	public List<EmployeeDTO> getAllCustomer(){
		return employeeDAO.fetchCustomer();
	}

}
