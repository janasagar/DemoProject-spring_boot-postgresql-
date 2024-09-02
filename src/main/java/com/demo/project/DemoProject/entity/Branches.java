package com.demo.project.DemoProject.entity;


import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "accountholders", schema = "public")
public class Branches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchID;
    private  String branchName;
    private String BranchLocation;
}
