package com.infy.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedQuery;

import com.infy.dto.AddressDTO;
import com.infy.dto.EmployeeDTO;

@Entity
@NamedQuery(name="Employee.findByBaseLocation", query="select e from Employee e where e.baseLocation=?1")
public class Employee {
	@Id
	private int empId;
	private String empName;
	private String department;
	private String baseLocation;
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	private double empSalary;
	private String empBandLevel;
	private String empContactNumber;
	
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
		
	public Employee(int empId, String empName, String department, String baseLocation, Address address,
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
	
	public static EmployeeDTO prepareEmployeeDTO(Employee empEntity) {
		Address address = new Address(empEntity.getAddress().getAddressId(),empEntity.getAddress().getCity(), empEntity.getAddress().getPincode());
		AddressDTO addressDTO = Address.prepareAddressDTO(address);
		return new EmployeeDTO(empEntity.getEmpId(), empEntity.getEmpName(), empEntity.getDepartment(), empEntity.getBaseLocation(), addressDTO, empEntity.getEmpSalary(), empEntity.getEmpBandLevel(), empEntity.getEmpContactNumber());
		
	}
	
	
	
	

}
