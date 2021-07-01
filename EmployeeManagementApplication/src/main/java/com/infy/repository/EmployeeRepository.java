package com.infy.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.domain.Address;
import com.infy.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByDepartment(String dept);

}
