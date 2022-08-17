package com.example.EMS.service;

import java.util.List;

import com.example.EMS.entity.Department;
import com.example.EMS.entity.Employee;
import com.example.EMS.exceptions.ResourceNotFoundException;

public interface DepartmentService {
	
	Department addDepartment(Department department);
	
	List<Department> getAllDepartments();
	
	Department getDepartment(int departmentId) throws ResourceNotFoundException;
	
	Department updateDepartment(int departmentId, Department department) throws ResourceNotFoundException;
	
	void deleteDepartment(int departmentId) throws ResourceNotFoundException;
	
	List<Employee> getEmployees(int departmentId) throws ResourceNotFoundException;
	
}
