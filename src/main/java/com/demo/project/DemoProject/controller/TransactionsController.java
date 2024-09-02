package com.demo.project.DemoProject.controller;

import com.demo.project.DemoProject.entity.Transactions;
import com.demo.project.DemoProject.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService service;

    @GetMapping
    public List<Transactions> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable Long id) {
        Optional<Transactions> transaction = service.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transaction) {
        Transactions savedTransaction = service.saveTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transactions> updateTransaction(@PathVariable Long id, @RequestBody Transactions transaction) {
        if (!service.getTransactionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
//        transaction.setTransactionID(id);
        Transactions updatedTransaction = service.saveTransaction(transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        if (!service.getTransactionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
