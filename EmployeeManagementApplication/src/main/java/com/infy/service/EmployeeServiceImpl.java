package com.infy.service;

import java.util.List;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;
import com.infy.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeDAO;
	// default constructor
	public EmployeeServiceImpl() {
	}
	
	public void setRepository(EmployeeRepositoryImpl employeeDAO) {
		this.employeeDAO = (EmployeeRepository) employeeDAO;
	}
	
	public void insert(EmployeeDTO emp) {
		employeeDAO.insertEmployee(emp);		
	}

	public void delete(int empId) {
		employeeDAO.removeEmployee(empId);		
	}
	
	public List<EmployeeDTO> getAllCustomer(){
		return employeeDAO.fetchCustomer();
	}

}
