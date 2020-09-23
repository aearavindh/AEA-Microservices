package com.company.EmployeeDepartmentAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.company.EmployeeDepartmentAPI.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
