package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.exception.APIException;
import com.example.hibernate.practice.EmployeeProject.models.Department;
import com.example.hibernate.practice.EmployeeProject.models.Employee;
import com.example.hibernate.practice.EmployeeProject.repositories.DepartmentRepository;
import com.example.hibernate.practice.EmployeeProject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

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

    @Override
    public String deleteDepartment(String id) {
        Department fetchedDepartment =
                departmentRepository.findById(Long.parseLong(id)).orElseThrow(() -> new APIException("Failed to find " +
                        "department"));

//        List<Employee> employees = fetchedDepartment.getEmployee();
//
//        employees.forEach(employee ->{
//            employee.setDepartment(null);
//            employeeRepository.delete(employee);
//        });

        departmentRepository.delete(fetchedDepartment);
        return "Success";
    }


}
