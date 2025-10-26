package com.example.hibernate.practice.EmployeeProject.services;

import com.example.hibernate.practice.EmployeeProject.models.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public Task getSingleTaskBasedOnId(String id);
    public String saveSingleTask(Task task);
}
