package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.exception.APIException;
import com.example.hibernate.practice.EmployeeProject.models.Department;
import com.example.hibernate.practice.EmployeeProject.models.Employee;
import com.example.hibernate.practice.EmployeeProject.models.Task;
import com.example.hibernate.practice.EmployeeProject.repositories.DepartmentRepository;
import com.example.hibernate.practice.EmployeeProject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Employee> showAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee showSingleEmployee(String id) {
        return employeeRepository.findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public String saveSingleEmployee(Employee employee) {
        try {
            for(Task t: employee.getTask()){
                t.setEmployee(employee);
            }
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new APIException("Failed to save the employee");
        }
        return "Success";
    }

    @Override
    public String saveSingleEmployeeInExistingDepartment(Employee employee, String departmentId) {

        Department fetchedDepartment =
                departmentRepository.findById(Long.parseLong(departmentId)).orElseThrow(()-> new APIException("Can't " +
                        "find department with id: "+departmentId));

        employee.setDepartment(fetchedDepartment);

        employeeRepository.save(employee);

        return "Success";
    }


}
