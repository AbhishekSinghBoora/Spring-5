package com.infy.service;

import com.infy.dto.EmployeeDTO;

public interface EmployeeService {
	public void insert(EmployeeDTO emp);
	public void delete(int empId);

}
