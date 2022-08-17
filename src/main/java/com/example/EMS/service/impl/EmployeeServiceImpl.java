package com.example.EMS.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EMS.entity.Employee;
import com.example.EMS.exceptions.ResourceNotFoundException;
import com.example.EMS.repository.EmployeeRepository;
import com.example.EMS.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+id));
		return employee;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) throws ResourceNotFoundException {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+id));
		
		if(Objects.nonNull(employee.getName()) && !employee.getName().equalsIgnoreCase("")) {
			existingEmployee.setName(employee.getName());
		}
		
		if(Objects.nonNull(employee.getEmail()) && !employee.getEmail().equalsIgnoreCase("")) {
			existingEmployee.setEmail(employee.getEmail());
		}
		
		if(Objects.nonNull(employee.getPhone()) && !employee.getPhone().equalsIgnoreCase("")) {
			existingEmployee.setPhone(employee.getName());
		}
		
		if(Objects.nonNull(employee.getHireDate())) {
			existingEmployee.setHireDate(employee.getHireDate());
		}
		
		if(Objects.nonNull(employee.getDepartment())) {
			existingEmployee.setDepartment(employee.getDepartment());
		}
		
		if(Objects.nonNull(employee.getAddress())) {
			existingEmployee.setAddress(employee.getAddress());
		}
		
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(int id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+id));
		employeeRepository.delete(employee);
	}

	@Override
	public void deleteAllEmployee() {
		employeeRepository.deleteAll();
	}

	@Override
	public Map<String, String> nameDeptMap() {
		Map<String, String> map = employeeRepository.findAll()
			.stream()
			.collect(Collectors.toMap(Employee::getName, e->e.getDepartment().getName()));
		return map;
	}

}
