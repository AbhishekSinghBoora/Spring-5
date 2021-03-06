package com.infy.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.infy.domain.Employee;
import com.infy.dto.AddressDTO;
import com.infy.dto.EmployeeDTO;
import com.infy.repository.AddressRepository;
import com.infy.repository.EmployeeRepository;

@Service("employeeService")
//@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void addEmployee(EmployeeDTO emp) {
		repository.saveAndFlush(EmployeeDTO.prepareEmployeeEntity(emp));
		
	}

	@Override
	public EmployeeDTO searchEmployee(int empId) {
		Optional<Employee> optional = repository.findById(empId);
		Employee employee = optional.get();
		EmployeeDTO eDto = Employee.prepareEmployeeDTO(employee);
		return eDto;
	}

	@Override
	public List<EmployeeDTO> viewAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editEmployee(int empId, String newDept) {
		Optional<Employee> optional = repository.findById(empId);
		Employee employee = optional.get();
		employee.setDepartment(newDept);
		repository.save(employee);
		System.out.println("The department for the employee (EmpId:"+empId+") has been updated successfully.");
	}

	@Override
	public void removeEmployee(int empId) {
		repository.deleteById(empId);
		
	}
	
	// pagination method
	@Override
	public Page<Employee> findAll(Pageable page) {
		return repository.findAll(page);
	}

	// sorting method
	@Override
	public List<Employee> findAll(Sort sort) {
		return repository.findAll(sort);
	}
	
	// query creation using method name 
	public Iterable<Employee> getEmployeeByDepartment(String dept) {
		return repository.findByDepartment(dept);
	}
	
	// query creation using @Query  
	public Iterable<Employee> getEmployeeByBandLevel(String bandLevel) {
		return repository.findByEmpBandLevel(bandLevel);
	}
	
	// query creation using @NamedQuery
	public Iterable<Employee> getEmployeeByBaseLocation(String location) {
		return repository.findByBaseLocation(location);
	}
	
	// update on Employee and Address table
	public void updateEmployee(EmployeeDTO eDto) {
		// method to update address in employee table
		repository.updateEmployeeAddress(AddressDTO.prepareAddressEntity(eDto.getAddress()), eDto.getEmpId());
		
		// method to update new address details in address table
		addressRepository.updateAddress(EmployeeDTO.prepareEmployeeEntity(eDto).getAddress().getCity(), EmployeeDTO.prepareEmployeeEntity(eDto).getAddress().getPincode(), EmployeeDTO.prepareEmployeeEntity(eDto).getAddress().getAddressId());
	}
	
	// method to search customer using custom repository method
	public List<Employee> searchEmployee(String eName, String eDept, String eBaseLocation, String eContactNumber){
		return repository.searchEmployee(eName, eDept, eBaseLocation, eContactNumber);
	}

	

}
