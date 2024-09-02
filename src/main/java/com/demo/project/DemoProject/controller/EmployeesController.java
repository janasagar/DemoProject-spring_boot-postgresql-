package com.demo.project.DemoProject.controller;

import com.demo.project.DemoProject.entity.Employees;
import com.demo.project.DemoProject.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService service;

    @GetMapping
    public List<Employees> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Long id) {
        Optional<Employees> employee = service.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employees> createEmployee(@RequestBody Employees employee) {
        Employees savedEmployee = service.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Long id, @RequestBody Employees employee) {
        if (!service.getEmployeeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
//        employee.setEmployeeID(id);
        Employees updatedEmployee = service.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!service.getEmployeeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}