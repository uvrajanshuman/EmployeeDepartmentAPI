package com.example.EMS.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EMS.entity.Department;
import com.example.EMS.entity.Employee;
import com.example.EMS.exceptions.ResourceNotFoundException;
import com.example.EMS.repository.DepartmentRepository;
import com.example.EMS.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(int departmentId) throws ResourceNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if(!department.isPresent()) {
			throw new ResourceNotFoundException("Department not found with id: "+departmentId);
		}
		return department.get();
	}

	@Override
	public Department updateDepartment(int departmentId, Department department) throws ResourceNotFoundException {
		Department existingDepartment = departmentRepository.findById(departmentId)
				.orElseThrow(()-> new ResourceNotFoundException("Department not found with id: " + departmentId));
		if(Objects.nonNull(department.getName()) && !department.getName().equalsIgnoreCase("")) {
			existingDepartment.setName(department.getName());
		}
		if(Objects.nonNull(department.getCode()) && !department.getCode().equalsIgnoreCase("")) {
			existingDepartment.setCode(department.getCode());
		}
		
		return departmentRepository.save(existingDepartment);
	}

	@Override
	public void deleteDepartment(int departmentId) throws ResourceNotFoundException {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(()->new ResourceNotFoundException("Department not found with id: "+departmentId));
		departmentRepository.delete(department);
	}

	@Override
	public List<Employee> getEmployees(int departmentId) throws ResourceNotFoundException {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(()->new ResourceNotFoundException("Department not found with id: "+departmentId));
		return department.getEmployees();
	}

}
