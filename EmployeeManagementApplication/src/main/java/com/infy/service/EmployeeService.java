package com.infy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infy.domain.Employee;
import com.infy.dto.EmployeeDTO;

public interface EmployeeService {
	public void addEmployee(EmployeeDTO emp);
	public EmployeeDTO searchEmployee(int empId);
	public List<EmployeeDTO> viewAllEmployee();
	public void editEmployee(int empId, String dept);
	public void removeEmployee(int empId);
	Page<Employee> findAll(Pageable page);
	List<Employee> findAll(Sort sort);
	public Iterable<Employee> getEmployeeByDepartment(String dept);
	public Iterable<Employee> getEmployeeByBandLevel(String bandLevel);
	public Iterable<Employee> getEmployeeByBaseLocation(String baseLocation);
	
	// method to update employee record
	public void updateEmployee(EmployeeDTO employeeDTO);
	
	// method to search customer using custom repository method
	public List<Employee> searchEmployee(String eName, String eDept, String eBaseLocation, String eContactNumber);
	
}
