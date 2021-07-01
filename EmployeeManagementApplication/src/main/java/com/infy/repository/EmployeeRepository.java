package com.infy.repository;

import java.util.List;

import javax.transaction.Transactional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infy.domain.Address;
import com.infy.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	// query creation based on method names
	List<Employee> findByDepartment(String dept); 
	
	// query creation using @NamedQuery
	List<Employee> findByBaseLocation(String baseLocation);
	
	// query creation using @Query
	@Query ("select emp from Employee emp where emp.empBandLevel=?1")
	List<Employee> findByEmpBandLevel(String bandLevel);

	// method to update a employee record into DB
	@Transactional
	@Modifying
	@Query(value="update Employee set address = ? "+" where emp_id = ?", nativeQuery = true)
	public void updateEmployeeAddress(Address address, int empId);
}
