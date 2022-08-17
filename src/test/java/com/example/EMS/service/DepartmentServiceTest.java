package com.example.EMS.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EMS.entity.Department;
import com.example.EMS.exceptions.ResourceNotFoundException;
import com.example.EMS.repository.DepartmentRepository;
import com.example.EMS.service.impl.DepartmentServiceImpl;

import util.DepartmentTestUtil;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
	
	@Mock
	private DepartmentRepository departmentRepository;
	
	@InjectMocks
	private DepartmentServiceImpl deparmentService;
	
	private DepartmentTestUtil testUtil;
	
	@BeforeEach
	void setup() {
		testUtil = new DepartmentTestUtil();
	}

	@Test
	void addDepartment_success() {
		when(departmentRepository.save(testUtil.RECORD1))
			.thenReturn(testUtil.RECORD1);
		
		assertEquals(deparmentService.addDepartment(testUtil.RECORD1),testUtil.RECORD1); 
	}
	
	@Test
	void getAllDepartment_success() {
		
		List<Department> expectedList = testUtil.DEPARTMENT_LIST;
		when(departmentRepository.findAll())
		.thenReturn(expectedList);
		
		List<Department> actualList = deparmentService.getAllDepartments();
		
		assertArrayEquals(expectedList.toArray(),actualList.toArray());
	}
	
	
	@Test
	void getDepartmentById_success() throws ResourceNotFoundException  {
		Department expected = testUtil.RECORD1;
		when(departmentRepository.findById(1))
		.thenReturn(Optional.of(expected));
		
		assertEquals(expected,deparmentService.getDepartment(1));
	}
	
	@Test
	@DisplayName("ResourceNotFoundException on get Request for invalid ID")
	void getDepartmentById_failure() {
		Mockito.when(departmentRepository.findById(3))
		.thenThrow(new ResourceNotFoundException("Department not found with id: 3"));
		
		assertThrows(ResourceNotFoundException.class, ()->deparmentService.getDepartment(3));
	}
	
	@Test
	void updateDepartment_success() {
		Department expected = testUtil.RECORD2;
		
		when(departmentRepository.findById(2))
			.thenReturn(Optional.of(expected));
		
		when(departmentRepository.save(expected))
			.thenReturn(expected);
		
		assertEquals(expected, deparmentService.updateDepartment(2, expected));	
	}
	
	@Test 
	@DisplayName("ResourceNotFoundException on update Request for invalid ID")
	void updateDepartment_failure() {		
		when(departmentRepository.findById(2))
			.thenThrow(new ResourceNotFoundException("Department not found with id: 3"));

		assertThrows(ResourceNotFoundException.class, ()->deparmentService.updateDepartment(2, testUtil.RECORD2));
		
	}
	
	@Test
	void deleteDepartment_success() {
		Department expected = testUtil.RECORD2;
		
		when(departmentRepository.findById(2))
			.thenReturn(Optional.of(expected));
		
		doNothing().when(departmentRepository).delete(expected);
		
		assertDoesNotThrow(()->deparmentService.deleteDepartment(2));
	}
	
	@Test
	void deleteDepartment_failure() {
		
		when(departmentRepository.findById(2))
			.thenThrow(new ResourceNotFoundException("Department not found with id: 3"));
				
		assertThrows(ResourceNotFoundException.class, ()->deparmentService.deleteDepartment(2));
	}

}
