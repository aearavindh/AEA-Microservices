package com.company.EmployeeDepartmentAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.company.EmployeeDepartmentAPI.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
