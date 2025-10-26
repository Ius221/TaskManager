package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.exception.APIException;
import com.example.hibernate.practice.EmployeeProject.models.Department;
import com.example.hibernate.practice.EmployeeProject.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchADepartment(String id) {
        return departmentRepository.findById(Long.parseLong(id)).orElseThrow(() -> new APIException(
                "Department with id: "+id+" isn't exist"));
    }

    @Override
    public String createNewDepartment(Department department) {
        try{
            departmentRepository.save(department);
        } catch (Exception e) {
            throw new APIException("Failed to Create New Department");
        }
        return "Success";
    }


}
