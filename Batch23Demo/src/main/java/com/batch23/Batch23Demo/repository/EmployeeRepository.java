package com.batch23.Batch23Demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.batch23.Batch23Demo.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public List<Employee> findByEmployeeName(String employeeName);
	public List<Employee> findByEmployeeAddress(String employeeAddress);
	public Employee findByEmployeeNameAndEmployeeAddress(String employeeName,String employeeAddress);
	public List<Employee> findByEmployeeNameOrEmployeeAddress(String employeeName,String employeeAddress);
	//Query by JPQL
	@Query("from Employee where employeeName=:employeeName")
	public List<Employee> getEmployeeByName(@Param("employeeName")String employeeName);
	@Query("from Employee where employeeName=:employeeName and employeeAddress=:employeeAddress")
	public List<Employee> getEmployeeNameAndEmployeeAddress(@Param("employeeName") String employeeName, @Param("employeeAddress") String employeeAddress);
	@Query("select emp.employeeName,emp.employeeAddress from Employee emp")
	public List<Object[]> getEmployees();
	//Query by SQL
	@Query(value="select * from employee",nativeQuery=true)
	public List<Employee> findAllEmployees();

}
