package com.infy.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//	public void insertEmployee(Employee emp);
//	public void removeEmployee(int empId) throws Exception;
//	public List<Employee> fetchEmployees();
//	public void updateEmployee(int empId, Employee emp);

}
