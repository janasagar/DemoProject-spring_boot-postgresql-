package com.demo.project.DemoProject.services;

import com.demo.project.DemoProject.entity.Branches;
import com.demo.project.DemoProject.repository.BranchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchesService {

    @Autowired
    private BranchesRepository repository;

    public List<Branches> getAllBranches() {
        return repository.findAll();
    }

    public Optional<Branches> getBranchById(Long id) {
        return repository.findById(id);
    }

    public Branches saveBranch(Branches branch) {
        return repository.save(branch);
    }

    public void deleteBranch(Long id) {
        repository.deleteById(id);
    }
}