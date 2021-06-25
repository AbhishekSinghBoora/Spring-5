package com.infy.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.infy.dto.EmployeeDTO;

@Repository("employeeRepository")
//@Scope("singleton")
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	@PostConstruct
	public void initializer() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(101);
		employeeDTO.setEmpName("Jack");
		employeeDTO.setDepartment("ETA");
		employees = new ArrayList<EmployeeDTO>();
		employees.add(employeeDTO);
		
	}

	List<EmployeeDTO> employees = null;
	
	// add the new employee to employees list
	public void insertEmployee(EmployeeDTO emp) {
		employees.add(emp);
		
	}

	// remove the employee form the employees list using employee id
	public void removeEmployee(int empId) throws Exception{
		for(EmployeeDTO emp:employees) {
			if(emp.getEmpId()==empId) {
				employees.remove(emp);
				System.out.println("Employee with EmpId "+empId+" deleted successfully");
				break;
			}else {
				throw new Exception("Employee does not exist");
			}
		}
		
		
	}

	// return a list of employees
	public List<EmployeeDTO> fetchEmployees() {
		return employees;
	}

	// update the department of an employee
	@Override
	public void updateEmployee(int empId, EmployeeDTO emp) {
		String response = "Employee of EmpId :"+empId+ "\tdoes not exist";
		for(EmployeeDTO e:employees) {
			if(e.getEmpId()==empId) {
				if(emp.getEmpName()!=null)
					e.setEmpName(emp.getEmpName());
				if(emp.getDepartment()!=null)
					e.setDepartment(e.getDepartment());
				
				employees.set(empId, e);
				response = "Employee of EmpId "+e.getEmpId()+"\t got updated successfully";
				break;
			}
		}
		System.out.println(response);
		
	}
	

}
