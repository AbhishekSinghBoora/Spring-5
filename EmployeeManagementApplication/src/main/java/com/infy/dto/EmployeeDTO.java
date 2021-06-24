package com.infy.dto;

public class EmployeeDTO {
	private int empId;
	private String empName;
	private String department;
	
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
	
	// parameterized constructor
	public EmployeeDTO(int empId, String empName, String department) {
		this.empId = empId;
		this.empName = empName;
		this.department = department;
	}
	
	// default constructor
	public EmployeeDTO() {
		
	}
	
	

}
