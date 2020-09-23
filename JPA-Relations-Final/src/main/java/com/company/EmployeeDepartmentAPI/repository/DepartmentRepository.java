package com.company.EmployeeDepartmentAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.company.EmployeeDepartmentAPI.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
