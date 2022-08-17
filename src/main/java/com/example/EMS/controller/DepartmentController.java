package com.example.EMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EMS.entity.Department;
import com.example.EMS.entity.Employee;
import com.example.EMS.exceptions.ResourceNotFoundException;
import com.example.EMS.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		List<Department> departmentList = departmentService.getAllDepartments();
		return ResponseEntity.status(HttpStatus.OK).body(departmentList);
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int Id) throws ResourceNotFoundException{
		Department department = departmentService.getDepartment(Id);
		return ResponseEntity.status(HttpStatus.OK).body(department);
	}
	
	@GetMapping("/departments/{id}/employees")
	public ResponseEntity<List<Employee>> getDepartmentEmployees(@PathVariable("id") int Id) throws ResourceNotFoundException{
		List<Employee> employeeList = departmentService.getEmployees(Id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);
	}
	
	@PostMapping("/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		Department addedDepartment = departmentService.addDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedDepartment);
	}
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") int Id, @RequestBody Department department) throws ResourceNotFoundException{
		Department updatedDepartment = departmentService.updateDepartment(Id, department);
		return ResponseEntity.status(HttpStatus.OK).body(updatedDepartment);
	}
	
	
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("id") int Id) throws ResourceNotFoundException{
		departmentService.deleteDepartment(Id);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
}
