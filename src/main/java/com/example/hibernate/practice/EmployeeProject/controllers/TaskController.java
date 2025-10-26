package com.example.hibernate.practice.EmployeeProject.controllers;

import com.example.hibernate.practice.EmployeeProject.models.Task;
import com.example.hibernate.practice.EmployeeProject.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/api/public/allTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> allTasks = taskService.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.FOUND);
    }

    @GetMapping("/api/public/task/{id}")
    public ResponseEntity<Task> getSingleTask(@PathVariable String id) {
        Task singleTask = taskService.getSingleTaskBasedOnId(id);
        return new ResponseEntity<>(singleTask, HttpStatus.FOUND);
    }

    @PostMapping("/api/public/task")
    public ResponseEntity<String> saveTask(@RequestBody Task task) {
        String status = taskService.saveSingleTask(task);
        return new ResponseEntity<>(status, HttpStatus.FOUND);
    }

    @PutMapping("/api/public/update/task/status/{id}")
    public ResponseEntity<String> updateTask(@RequestBody Task task, @PathVariable String id) {
        String status = taskService.updateTaskStatus(task,id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/api/public/department/allTask/{id}")
    public ResponseEntity<List<Task>> allTaskOfADepartment(@PathVariable String id){
        List<Task> allTasks = taskService.allTaskOfADepartment(id);
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }


}
