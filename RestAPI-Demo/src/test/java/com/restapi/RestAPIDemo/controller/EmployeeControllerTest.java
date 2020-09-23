package com.restapi.RestAPIDemo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.RestAPIDemo.entity.Employee;
import com.restapi.RestAPIDemo.service.EmployeeService;
@ExtendWith(SpringExtension.class)   //@RunsWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)

@TestMethodOrder(OrderAnnotation.class)
class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService service;

	@Test
	@Order(1)
	void getEmployees() throws Exception {
				
		RequestBuilder request;
		
		List<Employee> asList = Arrays.asList(
		new Employee(1,"Neil","London"),
		new Employee(2,"Naill","Cardiff")
		);
		
		System.out.println("Response :"+asList.toString());
		when(service.getEmployees()).thenReturn(
				asList
				);
		request=MockMvcRequestBuilders
				.get("/employees")
				.accept(MediaType.APPLICATION_JSON);
		
		String expectedResult="[{employeeId:1,employeeName:Neil,employeeAddress:London},{employeeId:2,employeeName:Naill,employeeAddress:Cardiff}]";
		MvcResult result =mockMvc.perform(request)
			   .andExpect(status().isOk())
			   .andExpect(content().json(expectedResult))
			   .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	
		
	}
	
	@Test
	@Order(2)
	void createEmployees() throws Exception {
				
		RequestBuilder request;
		ObjectMapper objectMapper=new ObjectMapper();
		
		Employee employee=new Employee(1,"Neil","London");
		Employee mockEmployee=new Employee(2,"Naill","Cardiff");
		
			
		when(service.createEmployee(any(Employee.class))).thenReturn(mockEmployee);
		
		request=MockMvcRequestBuilders
				.post("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee));
		
		
		MvcResult result = mockMvc.perform(request).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
			  
		
		
	}

}

