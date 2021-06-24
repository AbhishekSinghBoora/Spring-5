package com.infy.repository;

import java.util.List;

import com.infy.dto.EmployeeDTO;

public interface EmployeeRepository {
	public void insertEmployee(EmployeeDTO emp);
	public void removeEmployee(int empId);
	public List<EmployeeDTO> fetchCustomer();

}
