package com.example.EMS.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EMS.entity.Employee;
import com.example.EMS.exceptions.ResourceNotFoundException;
import com.example.EMS.repository.EmployeeRepository;
import com.example.EMS.service.impl.EmployeeServiceImpl;

import util.EmployeeTestUtil;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	private EmployeeTestUtil testUtil;
	
	@BeforeEach
	void setup() {
		testUtil = new EmployeeTestUtil();
	}
	
	@Test
	void addEmployee_success() {
		Employee expected = testUtil.RECORD1;
		when(employeeRepository.save(expected))
			.thenReturn(expected);
		
		assertEquals(expected, employeeService.addEmployee(expected));
	}

	@Test
	void getAllEmployee_success() {
		when(employeeRepository.findAll())
		.thenReturn(testUtil.EMPLOYEE_LIST);
		
		assertArrayEquals(testUtil.EMPLOYEE_LIST.toArray(), 
				employeeService.getAllEmployee().toArray());
	}
	
	@Test
	void getEmployee_success() {
		Employee expected = testUtil.RECORD2;
		
		when(employeeRepository.findById(2))
		.thenReturn(Optional.of(expected));
		
		assertEquals(expected, employeeService.getEmployee(2));
	}
	
	@Test
	void getEmployee_failure() {		
		when(employeeRepository.findById(2))
			.thenThrow(new ResourceNotFoundException("Employee not found with id: 2"));
		
		assertThrows(ResourceNotFoundException.class, ()->employeeService.getEmployee(2));
	}
	
	@Test
	void updateEmployee_success() {
		Employee expected = testUtil.RECORD2;
		
		when(employeeRepository.findById(2))
			.thenReturn(Optional.of(expected));
		
		when(employeeRepository.save(expected))
		.thenReturn(expected);
		
		assertEquals(expected, employeeService.updateEmployee(2, expected));
	}
	
	@Test
	void updateEmployee_failure() {
		
		when(employeeRepository.findById(3))
			.thenThrow(new ResourceNotFoundException("Employee not found with id: 3"));
		
		assertThrows(ResourceNotFoundException.class, ()->employeeService.updateEmployee(3, testUtil.RECORD3));
	}
	
	@Test
	void deleteEmployee_success() {
		Employee expected = testUtil.RECORD3;
		
		when(employeeRepository.findById(3))
			.thenReturn(Optional.of(expected));
		
		doNothing().when(employeeRepository).delete(expected);
		
		assertDoesNotThrow(()->employeeService.deleteEmployee(3));
	}
	
	@Test
	void deleteEmployee_failure() {		
		when(employeeRepository.findById(3))
			.thenThrow(new ResourceNotFoundException("Employee not found with id: 3"));
				
		assertThrows(ResourceNotFoundException.class, ()->employeeService.deleteEmployee(3));
	}
	
	@Test 
	void deleteAll_success() {
		doNothing().when(employeeRepository).deleteAll();
		assertDoesNotThrow(()->employeeService.deleteAllEmployee());
	}
	
	@Test
	void nameDeptMap_success() {
		when(employeeRepository.findAll())
			.thenReturn(testUtil.EMPLOYEE_LIST);
		
		assertTrue(employeeService.nameDeptMap().equals(testUtil.NAME_DEPT_MAP));
	}
	
}
