package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.models.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> fetchAllDepartments();
    public Department fetchADepartment(String id);
    public String createNewDepartment(Department department);
    public String deleteDepartment(String id);
}
