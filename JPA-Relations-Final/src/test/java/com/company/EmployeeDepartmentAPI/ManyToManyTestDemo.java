package com.company.EmployeeDepartmentAPI;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.EmployeeDepartmentAPI.entity.Account;
import com.company.EmployeeDepartmentAPI.entity.Customer;
import com.company.EmployeeDepartmentAPI.entity.Department;
import com.company.EmployeeDepartmentAPI.entity.Employee;
import com.company.EmployeeDepartmentAPI.repository.CustomerRepository;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class ManyToManyTestDemo {
	@Autowired
	private CustomerRepository repository;

	@Test
	@Order(1)
	void test_saveCustomer() {
		Customer firstCustomer=new Customer();
		firstCustomer.setFirstName("Suresh");
		firstCustomer.setLastName("Kumar");
		firstCustomer.setEmail("suresh.kumar@wipro.com");
		
		Customer secondCustomer=new Customer();
		secondCustomer.setFirstName("Ramesh");
		secondCustomer.setLastName("Kumar");
		secondCustomer.setEmail("ramesh.kumar@wipro.com");
		
		Account savingsAccountForCustomerOne=new Account();
		savingsAccountForCustomerOne.setAccountType("Savings");
		savingsAccountForCustomerOne.setBalance(20000d);
		
		Account currentAccountForCustomerOne=new Account();
		currentAccountForCustomerOne.setAccountType("Current");
		currentAccountForCustomerOne.setBalance(30000d);
		
		Account savingsAccountForCustomerTwo=new Account();
		savingsAccountForCustomerTwo.setAccountType("Savings");
		savingsAccountForCustomerTwo.setBalance(40000d);
		
		Account currentAccountForCustomerTwo=new Account();
		currentAccountForCustomerTwo.setAccountType("Current");
		currentAccountForCustomerTwo.setBalance(50000d);
		
		/**********************************************************/
		Set<Account> accountsForCustomerOne=new HashSet<Account>();
		accountsForCustomerOne.add(savingsAccountForCustomerOne);
		accountsForCustomerOne.add(currentAccountForCustomerOne);
		firstCustomer.setAccounts(accountsForCustomerOne);
		
		Set<Account> accountsForCustomerTwo=new HashSet<Account>();
		accountsForCustomerTwo.add(savingsAccountForCustomerTwo);
		accountsForCustomerTwo.add(currentAccountForCustomerTwo);
			
		secondCustomer.setAccounts(accountsForCustomerTwo);
		
		
		Set<Customer> customers=new HashSet<Customer>();
		customers.add(firstCustomer);
		
		savingsAccountForCustomerOne.setCustomers(customers);
		currentAccountForCustomerOne.setCustomers(customers);
		repository.save(firstCustomer);
		customers=null;
		
		customers=new HashSet<Customer>();
		customers.add(secondCustomer);
		savingsAccountForCustomerTwo.setCustomers(customers);
		currentAccountForCustomerTwo.setCustomers(customers);
		
		
		
		
		repository.save(secondCustomer);
		
		
	}
	
	@Transactional
	@Test
	@Order(2)
	void test_getCustomers() {
		
		System.out.println("In get Customers method");
		
		Iterable<Customer> customers = repository.findAll();
		
		Iterator<Customer> itr=customers.iterator();
		
		while(itr.hasNext()) {
			Customer customer=itr.next();
			System.out.println("Customer Details:");
			System.out.println(customer);
			Set<Account> accounts = customer.getAccounts();
			System.out.println("Account Details:");
			for(Account account:accounts) {
				System.out.println(account);
			}
		}
		
	}

}
