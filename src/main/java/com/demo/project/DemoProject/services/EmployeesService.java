package com.demo.project.DemoProject.services;

import com.demo.project.DemoProject.entity.Employees;
import com.demo.project.DemoProject.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository repository;

    public List<Employees> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employees> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employees saveEmployee(Employees employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}