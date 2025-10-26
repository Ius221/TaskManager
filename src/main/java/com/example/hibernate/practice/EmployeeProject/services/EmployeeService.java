package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.models.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> showAllEmployee();
    public Employee showSingleEmployee(String id);
    public String saveSingleEmployee(Employee employee);
    public String saveSingleEmployeeInExistingDepartment(Employee employee, String departmentId);
}
