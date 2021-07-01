package com.infy.dto;

import com.infy.domain.Address;
import com.infy.domain.Employee;

public class EmployeeDTO {

	private int empId;
	private String empName;
	private String department;
	private String baseLocation;
	private AddressDTO address;
	private double empSalary;
	private String empBandLevel;
	private String empContactNumber;
	
	// getter and setter methods
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
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
	
	// constructor
	public EmployeeDTO() {}
		
	public EmployeeDTO(int empId, String empName, String department, String baseLocation, AddressDTO address,
			double empSalary, String empBandLevel, String empContactNumber) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.baseLocation = baseLocation;
		this.address = address;
		this.empSalary = empSalary;
		this.empBandLevel = empBandLevel;
		this.empContactNumber = empContactNumber;
	}
		
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + department + ", baseLocation="
				+ baseLocation + ", address=" + address + ", empSalary=" + empSalary + ", empBandLevel=" + empBandLevel
				+ ", empContactNumber=" + empContactNumber + "]";
	}
	public static Employee prepareEmployeeEntity(EmployeeDTO eDto) {
		Address address = new Address(eDto.getAddress().getAddressId(), eDto.getAddress().getCity(), eDto.getAddress().getPincode());
		return new Employee(eDto.getEmpId(), eDto.getEmpName(), eDto.getDepartment(), eDto.getBaseLocation(), address, eDto.getEmpSalary(), eDto.getEmpBandLevel(), eDto.getEmpContactNumber());
	}
	
	
}
