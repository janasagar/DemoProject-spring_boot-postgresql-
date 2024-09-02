package com.demo.project.DemoProject.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;




@Entity
@Data
@Table(name = "accountholders", schema = "public")
public class Accountholders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountholderID;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
