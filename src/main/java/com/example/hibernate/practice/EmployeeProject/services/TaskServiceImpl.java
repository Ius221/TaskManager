package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.exception.APIException;
import com.example.hibernate.practice.EmployeeProject.models.Task;
import com.example.hibernate.practice.EmployeeProject.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getSingleTaskBasedOnId(String id) {
        return taskRepository.findById(Long.parseLong(id)).orElseThrow(()->new APIException("Task Not Found With Id: " + id));
    }

    @Override
    public String saveSingleTask(Task task) {
        try{
            taskRepository.save(task);
        } catch (Exception e) {
            throw new APIException("Failed to save task");
        }
        return "Success";
    }
}
