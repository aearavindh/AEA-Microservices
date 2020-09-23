package com.batch23.Batch23Demo.io;

public class Employee {
	
	
	private String employeeName;
	private String employeeAddress;
	
	public Employee() {
		
	}
	
	
	
	
	
	
	public Employee(String employeeName, String employeeAddress) {
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + "]";
	}
	
	

}
