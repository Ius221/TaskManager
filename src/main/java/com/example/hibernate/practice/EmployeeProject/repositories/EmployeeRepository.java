package com.example.hibernate.practice.EmployeeProject.repositories;

import com.example.hibernate.practice.EmployeeProject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
