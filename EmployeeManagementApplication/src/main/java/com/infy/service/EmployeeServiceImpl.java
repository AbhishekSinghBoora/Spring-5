package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeDAO;
//	// default constructor
//	public EmployeeServiceImpl() {
//	}
//	@Autowired // auto-wiring on setter method
//	public void setRepository(EmployeeRepositoryImpl employeeDAO) {
//		this.employeeDAO = (EmployeeRepository) employeeDAO;
//	}
	
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
