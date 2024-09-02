package com.demo.project.DemoProject.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "employees", schema = "public")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeID;

    private String firstName;
    private String lastName;
    private String position;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branches branch;

    private Timestamp hireDate;
}
