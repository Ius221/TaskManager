package com.example.hibernate.practice.EmployeeProject.repositories;

import com.example.hibernate.practice.EmployeeProject.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
