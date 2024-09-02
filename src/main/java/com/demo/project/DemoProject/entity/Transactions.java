package com.demo.project.DemoProject.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "transactions", schema = "public")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionID;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private BigDecimal amount; // Corrected spelling from 'ammount' to 'amount'
    private String transType;
    private Timestamp transactionDate;
}