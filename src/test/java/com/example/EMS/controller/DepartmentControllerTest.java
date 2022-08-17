package com.example.EMS.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
import com.example.EMS.service.DepartmentService;

import util.DepartmentTestUtil;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private DepartmentTestUtil testUtil;
	
	@BeforeEach
	void setup() {
		testUtil = new DepartmentTestUtil();
	}

	@Test
	void getDepartmentById_Success() throws Exception {
		
		when(departmentService.getDepartment(2))
			.thenReturn(testUtil.RECORD2);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/departments/2")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
		
		
		String expectedJSON = testUtil.RECORD2_JSON;
		JSONAssert.assertEquals(expectedJSON, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	void getAllDepartments_success() throws Exception {
		
		List<Department> deptList = testUtil.DEPARTMENT_LIST;
		
		when(departmentService.getAllDepartments())
			.thenReturn(deptList);
		
		MvcResult result =  mockMvc.perform(get("/departments")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
		String expectedJSON = testUtil.DEPARTMENT_LIST_JSON;
		JSONAssert.assertEquals(expectedJSON, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	void addDepartment_Success() throws Exception{
		
		when(departmentService.addDepartment(testUtil.RECORD1))
		.thenReturn(testUtil.RECORD1);
		
		String payloadJSON = testUtil.RECORD1_JSON;
		RequestBuilder request = MockMvcRequestBuilders
				.post("/departments")
				.accept(MediaType.APPLICATION_JSON)
				.content(payloadJSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isCreated())
				.andReturn();
		
		String expectedJSON = testUtil.RECORD1_JSON;
		JSONAssert.assertEquals(expectedJSON, result.getResponse().getContentAsString(),false);
	}
	
	@Test
	void updateDepartment_Success() throws Exception {
		
		when(departmentService.updateDepartment(2, testUtil.RECORD2))
			.thenReturn(testUtil.RECORD2);
		
		String payloadJSON = testUtil.RECORD2_JSON;
		RequestBuilder request = MockMvcRequestBuilders
				.put("/departments/2")
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
	void deleteDepartment_Success() throws Exception{
		Mockito.doNothing().when(departmentService).deleteDepartment(3);
		
		RequestBuilder request = MockMvcRequestBuilders
				.delete("/departments/3")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
			.andExpect(status().isOk());
		
	}

}
