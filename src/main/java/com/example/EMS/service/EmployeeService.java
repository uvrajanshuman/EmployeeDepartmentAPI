package com.example.EMS.service;

import java.util.List;
import java.util.Map;

import com.example.EMS.entity.Employee;
import com.example.EMS.exceptions.ResourceNotFoundException;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployee(int id) throws ResourceNotFoundException;
	
	Employee updateEmployee(int id, Employee employee) throws ResourceNotFoundException;
	
	void deleteEmployee(int id) throws ResourceNotFoundException;
	
	void deleteAllEmployee();
		
	Map<Integer, Map<String,String>> nameDeptMap();

}
