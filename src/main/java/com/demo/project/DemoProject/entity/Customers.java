package com.demo.project.DemoProject.entity;


import lombok.Data;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "customers", schema = "public")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Timestamp createdAt;
}

