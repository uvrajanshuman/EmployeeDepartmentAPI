package com.example.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EMS.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
