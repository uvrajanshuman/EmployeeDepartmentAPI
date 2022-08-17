package com.example.EMS.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

import com.example.EMS.entity.Employee;
import com.example.EMS.service.EmployeeService;

import util.EmployeeTestUtil;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	private EmployeeTestUtil testUtil;
	
	@BeforeEach
	void setup() {
		testUtil = new EmployeeTestUtil();
	}

	@Test
	void getEmployeeById_success() throws Exception {
				
		when(employeeService.getEmployee(3)).thenReturn(testUtil.RECORD3);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/employees/3")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
		
		String expectedJSON = testUtil.RECORD3_JSON;
		
		JSONAssert.assertEquals(expectedJSON, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	void getAllEmployees_success() throws Exception {
		
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
	
	@Test
	void addEmployee_success() throws Exception{
		Employee expected = testUtil.RECORD2;
		
		when(employeeService.addEmployee(expected))
			.thenReturn(expected);
		
		String payloadJSON = testUtil.RECORD2_JSON;
		RequestBuilder request = MockMvcRequestBuilders
				.post("/employees")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(payloadJSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isCreated())
				.andReturn();
		
		JSONAssert.assertEquals(payloadJSON, result.getResponse().getContentAsString(), false);
	}
	
	
	@Test 
	void updateEmployee_success() throws Exception{
		when(employeeService.updateEmployee(2, testUtil.RECORD2))
		.thenReturn(testUtil.RECORD2);
	
		String payloadJSON = testUtil.RECORD2_JSON;
		RequestBuilder request = MockMvcRequestBuilders
			.put("/employees/2")
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.content(payloadJSON);
	
		MvcResult result = mockMvc.perform(request)
			.andExpect(status().isOk())
			.andReturn();
	
		String expectedJSON = testUtil.RECORD2_JSON;
		JSONAssert.assertEquals(expectedJSON, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	void deleteAllEmployee_success() throws Exception{
		doNothing().when(employeeService).deleteAllEmployee();
		
		RequestBuilder request = MockMvcRequestBuilders
				.delete("/employees");
		
		mockMvc.perform(request)
			.andExpect(status().isOk());
	}
	
	@Test
	void deleteEmployeeById_success() throws Exception{
		doNothing().when(employeeService).deleteEmployee(3);
		
		RequestBuilder request = MockMvcRequestBuilders
				.delete("/employees/3");
		
		mockMvc.perform(request)
			.andExpect(status().isOk());
	}
	
}
