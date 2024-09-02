package com.demo.project.DemoProject.controller;

import com.demo.project.DemoProject.entity.Accountholders;
import com.demo.project.DemoProject.services.AccountholdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accountholders")
public class AccountholdersController {

    @Autowired
    private AccountholdersService service;

    @GetMapping
    public List<Accountholders> getAllAccountholders() {
        return service.getAllAccountholders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accountholders> getAccountholderById(@PathVariable Long id) {
        Optional<Accountholders> accountholder = service.getAccountholderById(id);
        return accountholder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Accountholders> createAccountholder(@RequestBody Accountholders accountholders) {
        Accountholders savedAccountholder = service.saveAccountholder(accountholders);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccountholder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accountholders> updateAccountholder(@PathVariable Long id, @RequestBody Accountholders accountholders) {
        if (!service.getAccountholderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        accountholders.setAccountholderID(id);
        Accountholders updatedAccountholder = service.saveAccountholder(accountholders);
        return ResponseEntity.ok(updatedAccountholder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountholder(@PathVariable Long id) {
        if (!service.getAccountholderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteAccountholder(id);
        return ResponseEntity.noContent().build();
    }
}