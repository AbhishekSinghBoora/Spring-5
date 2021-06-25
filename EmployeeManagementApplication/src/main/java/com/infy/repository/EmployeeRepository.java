package com.infy.repository;

import java.util.List;

import com.infy.dto.EmployeeDTO;

public interface EmployeeRepository {
	public void insertEmployee(EmployeeDTO emp);
	public void removeEmployee(int empId) throws Exception;
	public List<EmployeeDTO> fetchEmployees();
	public void updateEmployee(int empId, EmployeeDTO emp);

}
