package com.example.EMS.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.example.EMS.entity.Employee;
import com.example.EMS.exceptions.ResourceNotFoundException;
import com.example.EMS.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeService.getAllEmployee());
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int Id) throws ResourceNotFoundException{
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeService.getEmployee(Id));
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(employeeService.addEmployee(employee));
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int Id, @Valid @RequestBody Employee employee) throws ResourceNotFoundException{
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeService.updateEmployee(Id, employee));
		
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<?> deleteAllEmployee() {
		employeeService.deleteAllEmployee();
		return ResponseEntity
				.status(HttpStatus.OK)
				.build();
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int Id) throws ResourceNotFoundException{
		employeeService.deleteEmployee(Id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.build();
	}
	
	@GetMapping("/employees/name-dept-map")
	public ResponseEntity<Map<Integer, Map<String,String>>> getNameDeptMap(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeService.nameDeptMap());
	}
}
