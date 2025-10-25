package com.example.hibernate.practice.EmployeeProject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String position;
    private double salary;

    @OneToMany(mappedBy = "employee")
    private List<Task> task;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
}
