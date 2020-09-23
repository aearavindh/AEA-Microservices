package com.company.EmployeeDepartmentAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.company.EmployeeDepartmentAPI.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public Employee findByFirstNameAndLastName(String firstName,String lastName);
	public Employee findByFirstNameOrLastName(String firstName,String lastName);
		
	@Query("from Employee where firstName=:firstName and lastName=:lastName")
	public List<Employee> getEmployeeByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query("select emp.firstName,emp.lastName from Employee emp")
	public List<Object[]> getEmployees();
	@Query(value="select * from employees",nativeQuery=true)
	public List<Employee> findAllEmployees();
	
	

}
