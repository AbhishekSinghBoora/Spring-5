package com.infy.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.infy.dto.EmployeeDTO;

@Entity
public class Employee {
	@Id
	private int empId;
	private String empName;
	private String department;
	private String baseLocation;
	private double empSalary;
	private String empBandLevel;
	private String empContactNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	// getters and setters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpBandLevel() {
		return empBandLevel;
	}
	public void setEmpBandLevel(String empBandLevel) {
		this.empBandLevel = empBandLevel;
	}
	public String getEmpContactNumber() {
		return empContactNumber;
	}
	public void setEmpContactNumber(String empContactNumber) {
		this.empContactNumber = empContactNumber;
	}
	
	// constructors
	public Employee() {}

	public Employee(int empId, String empName, String department, String baseLocation, double empSalary,
			String empBandLevel, String empContactNumber, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.baseLocation = baseLocation;
		this.empSalary = empSalary;
		this.empBandLevel = empBandLevel;
		this.empContactNumber = empContactNumber;
		this.address = address;
	}
		
	public static EmployeeDTO prepareEmployeeDTO(Employee e) {
		EmployeeDTO eDto = new EmployeeDTO();
		eDto.setEmpId(e.getEmpId());
		eDto.setEmpName(e.getEmpName());
		eDto.setDepartment(e.getDepartment());
		eDto.setBaseLocation(e.getBaseLocation());
		eDto.setAddress(e.getAddress());
		eDto.setEmpSalary(e.getEmpSalary());
		eDto.setEmpBandLevel(e.getEmpBandLevel());
		eDto.setEmpContactNumber(e.getEmpContactNumber());
		return eDto;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + department + ", baseLocation="
				+ baseLocation + ", empSalary=" + empSalary + ", empBandLevel=" + empBandLevel + ", empContactNumber="
				+ empContactNumber + ", address=" + address + "]";
	}
	
	
	

}
