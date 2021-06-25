package com.infy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;
import com.infy.repository.EmployeeRepositoryImpl;

@Service("employeeService")
//@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService{
	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeDAO = new EmployeeRepositoryImpl();
	
	public void insert(EmployeeDTO emp) {
		employeeDAO.insertEmployee(emp);	
		System.out.println("Employee with EmpId "+emp.getEmpId()+" inserted successfully");
	}

	public void delete(int empId) {
		try {
			employeeDAO.removeEmployee(empId);
		}
		catch(Exception e) {
			logger.info("In log Exception");
			logger.error(e.getMessage(),e);
		}
	}
	
	public List<EmployeeDTO> getAllEmployees(){
		return employeeDAO.fetchEmployees();
	}

	@Override
	public void update(int empId, EmployeeDTO emp) {
		employeeDAO.updateEmployee(empId,emp);
	}

}
