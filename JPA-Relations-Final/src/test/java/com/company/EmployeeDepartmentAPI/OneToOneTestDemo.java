package com.company.EmployeeDepartmentAPI;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.EmployeeDepartmentAPI.entity.Department;
import com.company.EmployeeDepartmentAPI.entity.Employee;
import com.company.EmployeeDepartmentAPI.entity.License;
import com.company.EmployeeDepartmentAPI.entity.Person;
import com.company.EmployeeDepartmentAPI.repository.DepartmentRepository;
import com.company.EmployeeDepartmentAPI.repository.EmployeeRepository;
import com.company.EmployeeDepartmentAPI.repository.LicenseRepository;
import com.company.EmployeeDepartmentAPI.repository.PersonRepository;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class OneToOneTestDemo {
	@Autowired
	private LicenseRepository licenseRepository;
	
	

	@Test
	@Order(1)
	public void test_SaveLicense() {
		Person person=new Person();
		person.setPersonName("Hari");
		
		License license=new License();
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		person.setLicense(license);
		license.setPerson(person);
		
		Person person1=new Person();
		person1.setPersonName("Tom");
		
		License license1=new License();
		license1.setValidFrom(new Date());
		license1.setValidTo(new Date());
		
		person1.setLicense(license1);
		license1.setPerson(person1);
		
		
		licenseRepository.save(license);
		licenseRepository.save(license1);
		
		
		
		
		
		
	}
	
	
	@Test
	@Order(2)
	public void test_getLicense() {
		Iterable<License> licenses = licenseRepository.findAll();
		
		Iterator<License> iterator = licenses.iterator();
		while(iterator.hasNext()) {
			License license=iterator.next();
			Person person = license.getPerson();
			System.out.println("Person Details:"+person);
			System.out.println("License Details:"+license);
			
		}
	}
	

}
