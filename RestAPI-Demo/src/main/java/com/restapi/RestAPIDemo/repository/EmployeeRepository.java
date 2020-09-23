package com.restapi.RestAPIDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restapi.RestAPIDemo.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public Employee findByEmployeeName(String employeeName);
	public Employee findByEmployeeAddress(String employeeAddress);
	public Employee findByEmployeeNameAndEmployeeAddress(String employeeName,String employeeAddress);
	
	@Query("from Employee where employeeName=:employeeName and employeeAddress=:employeeAddress")
	public List<Employee> getEmployeeNameAndEmployeeAddress(@Param("employeeName") String employeeName, @Param("employeeAddress") String employeeAddress);
	
	@Query("select emp.employeeName,emp.employeeAddress from Employee emp")
	public List<Object[]> getEmployees();
	@Query(value="select * from employee where employee_name='"+"Vinay"+"'",nativeQuery=true)
	public List<Employee> findAllEmployees();

}
