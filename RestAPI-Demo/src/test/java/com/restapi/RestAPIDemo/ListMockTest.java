package com.restapi.RestAPIDemo;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ListMockTest {
	List list=mock(List.class); // You are creating an object and the default behaviour of the object is do nothing when not stubbed.
	ArrayList mockArrayList=mock(ArrayList.class);
	ArrayList spyArrayList=spy(ArrayList.class); 
	//It will behave like a normal object when you are not stubbing the method. If you a stub a method it will return stubbed value.
	

	@Test
	@Order(1)
	public void size_basics() {
		System.out.println("Size="+list.size());
		when(list.size()).thenReturn(5);
		assertEquals(5,list.size());
	}
	
	@Test
	@Order(2)
	public void mocking() {
		
		mockArrayList.add("Test 0");
		mockArrayList.add("Test 1");
		System.out.println("Mock  Size ="+mockArrayList.size());
		System.out.println("Mock Array List:0"+mockArrayList.get(0));
		System.out.println("Mock Array List:1"+mockArrayList.get(1));
		when(mockArrayList.size()).thenReturn(5);
		when(mockArrayList.get(0)).thenReturn("Hello World");
		
		System.out.println("Mock Size ="+mockArrayList.size());
		System.out.println("Mock Array List:0"+mockArrayList.get(0));
		System.out.println("Mock Array List:1"+mockArrayList.get(1));
		
	
		
		
		
		
		
	}
	@Test
	@Order(3)
	public void spying() {
		
		
	
		spyArrayList.add("Test 0");
		spyArrayList.add("Test 1");
		System.out.println("Spy Size ="+spyArrayList.size());
		System.out.println("Spy Array List:"+spyArrayList.get(0));
		System.out.println("Spy Array List:"+spyArrayList.get(1));
		when(spyArrayList.size()).thenReturn(5);
		when(spyArrayList.get(0)).thenReturn("Hello World");
		System.out.println("Spy Size ="+spyArrayList.size());
		System.out.println("Spy Array List 0:"+spyArrayList.get(0));
		System.out.println("Spy Array List 1:"+spyArrayList.get(1));
		
	}
	
	@Test
	@Order(4)
	public void returnDifferentValues() {
		when(list.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, list.size());
		assertEquals(10, list.size());
		
	}
	@Test
	@Order(6)
	public void returnWithParameters()  {
		when(list.get(0)).thenReturn("Hello World");
		assertEquals("Hello World",list.get(0));
		verify(list,times(1)).get(0);
		verify(list,atLeast(1)).get(0);
		verify(list,atLeastOnce()).get(0);
	}

}
