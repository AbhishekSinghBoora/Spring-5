package com.infy.service;

import java.util.List;

import com.infy.domain.Employee;
import com.infy.dto.EmployeeDTO;

public interface EmployeeService {
	public void addEmployee(EmployeeDTO emp);
	public EmployeeDTO searchEmployee(int empId);
	public List<EmployeeDTO> viewAllEmployee();
	public void editEmployee(int empId, String dept);
	public void removeEmployee(int empId);
	
}
