package com.infy.repository;

import java.util.List;

import com.infy.domain.Employee;

public interface IEmployeeRepository {
	// custom repository method to search employee 
	public List<Employee> searchEmployee(String eName, String eDept, String eBaseLocation, String eContactNumber);

}
