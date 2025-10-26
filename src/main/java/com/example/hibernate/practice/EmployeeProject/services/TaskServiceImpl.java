package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.exception.APIException;
import com.example.hibernate.practice.EmployeeProject.models.Department;
import com.example.hibernate.practice.EmployeeProject.models.Employee;
import com.example.hibernate.practice.EmployeeProject.models.Task;
import com.example.hibernate.practice.EmployeeProject.repositories.DepartmentRepository;
import com.example.hibernate.practice.EmployeeProject.repositories.EmployeeRepository;
import com.example.hibernate.practice.EmployeeProject.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getSingleTaskBasedOnId(String id) {
        return taskRepository.findById(Long.parseLong(id)).orElseThrow(() -> new APIException("Task Not Found With Id: " + id));
    }

    @Override
    public String saveSingleTask(Task task) {
        try {
            taskRepository.save(task);
        } catch (Exception e) {
            throw new APIException("Failed to save task");
        }
        return "Success";
    }

    @Override
    public String updateTaskStatus(Task task, String id) {

        Task fetchedTask = taskRepository.findById(Long.parseLong(id)).orElseThrow(() -> new APIException("Failed to " +
                "Found task"));

        fetchedTask.setStatus(task.getStatus());

        taskRepository.save(fetchedTask);

        return "Success";
    }

    @Override
    public List<Task> allTaskOfADepartment(String id) {
        Department department = departmentRepository.findById(Long.parseLong(id)).orElseThrow(() -> new APIException(
                "Department not found"));

        List<Task> allTasks = new ArrayList<>();
        List<Employee> employees = department.getEmployee();

        employees.forEach(employee -> {
            Employee emp = employeeRepository.findById(employee.getId()).orElseThrow(() -> new APIException("Unexpected" +
                    " Error"));

            List<Task> currTask = emp.getTask();
            allTasks.addAll(currTask);
        });

        return allTasks;
    }
}
