package com.batch23.Batch23Demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	private String employeeName;
	private String employeeAddress;
	
	public Employee() {
		
	}
	public Employee(Integer id,String employeeName, String employeeAddress) {
		this.employeeId=id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	
	
	
	
	public Employee(String employeeName, String employeeAddress) {
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + "]";
	}
	
	

}
