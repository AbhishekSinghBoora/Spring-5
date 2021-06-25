package com.infy.service;

import java.util.List;

import com.infy.dto.EmployeeDTO;

public interface EmployeeService {
	public void insert(EmployeeDTO emp);
	public void delete(int empId) throws Exception;
	public List<EmployeeDTO> getAllEmployees();
	public void update(int empId, EmployeeDTO emp);

}
