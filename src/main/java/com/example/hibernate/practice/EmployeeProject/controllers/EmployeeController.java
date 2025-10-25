package com.example.hibernate.practice.EmployeeProject.controllers;

import com.example.hibernate.practice.EmployeeProject.models.Employee;
import com.example.hibernate.practice.EmployeeProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/public/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.showAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.FOUND);
    }

    @GetMapping("/api/public/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        Employee employee = employeeService.showSingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @PostMapping("/api/public/employee")
    public ResponseEntity<String> saveSingleEmployee(@RequestBody Employee employee) {
        String status = employeeService.saveSingleEmployee(employee);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
