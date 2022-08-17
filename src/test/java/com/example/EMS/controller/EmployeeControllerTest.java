package com.example.EMS.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.EMS.entity.Department;
import com.example.EMS.entity.Employee;
import com.example.EMS.service.DepartmentService;
import com.example.EMS.service.EmployeeService;

import util.EmployeeTestUtil;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	private EmployeeTestUtil testUtil;

	@Test
	void getEmployeeById_success() throws Exception {
				
		when(employeeService.getEmployee(1)).thenReturn(testUtil.RECORD1);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/employees/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
		
		String expectedJSON = testUtil.RECORD1_JSON;
		
		JSONAssert.assertEquals(expectedJSON, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	void getAllDepartments_Success() throws Exception {
		
		List<Employee> empList = testUtil.EMPLOYEE_LIST;
		
		when(employeeService.getAllEmployee())
			.thenReturn(empList);
		
		MvcResult result =  mockMvc.perform(get("/employees")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
		String expectedJSON = testUtil.EMPLOYEE_LIST_JSON;
		JSONAssert.assertEquals(expectedJSON, result.getResponse().getContentAsString(), false);
	}

}
