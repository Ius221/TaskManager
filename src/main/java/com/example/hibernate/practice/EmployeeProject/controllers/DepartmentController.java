package com.example.hibernate.practice.EmployeeProject.controllers;

import com.example.hibernate.practice.EmployeeProject.models.Department;
import com.example.hibernate.practice.EmployeeProject.repositories.DepartmentRepository;
import com.example.hibernate.practice.EmployeeProject.services.DepartmentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/api/public/allDepartments")
    public ResponseEntity<List<Department>> fetchAllDepartment() {
        List<Department> departments = departmentService.fetchAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.FOUND);
    }

    @GetMapping("/api/public/department/{id}")
    public ResponseEntity<Department> fetchSingleDepartment(String id) {
        Department department = departmentService.fetchADepartment(id);
        return new ResponseEntity<>(department, HttpStatus.FOUND);
    }

    @PostMapping("/api/public/department")
    public ResponseEntity<String> createNewDepartment(@RequestBody Department department) {
        String status = departmentService.createNewDepartment(department);
        return new ResponseEntity<>(status, HttpStatus.FOUND);
    }

    @DeleteMapping("/api/public/department/{id}")
    public ResponseEntity<String> deleteADepartment(@PathVariable String id){
        String status = departmentService.deleteDepartment(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
