package com.demo.project.DemoProject.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    private String accountType;
    private BigDecimal balance;
    private Timestamp openedAt;
}