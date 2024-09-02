package com.demo.project.DemoProject.controller;

import com.demo.project.DemoProject.entity.Branches;
import com.demo.project.DemoProject.services.BranchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/branches")
public class BranchesController {

    @Autowired
    private BranchesService service;

    @GetMapping
    public List<Branches> getAllBranches() {
        return service.getAllBranches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branches> getBranchById(@PathVariable Long id) {
        Optional<Branches> branch = service.getBranchById(id);
        return branch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Branches> createBranch(@RequestBody Branches branch) {
        Branches savedBranch = service.saveBranch(branch);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBranch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Branches> updateBranch(@PathVariable Long id, @RequestBody Branches branch) {
        if (!service.getBranchById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        branch.setBranchID(id);
        Branches updatedBranch = service.saveBranch(branch);
        return ResponseEntity.ok(updatedBranch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        if (!service.getBranchById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
