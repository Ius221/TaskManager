package com.example.hibernate.practice.EmployeeProject.repositories;

import com.example.hibernate.practice.EmployeeProject.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
