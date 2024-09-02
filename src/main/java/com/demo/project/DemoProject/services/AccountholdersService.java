package com.demo.project.DemoProject.services;

import com.demo.project.DemoProject.entity.Accountholders;
import com.demo.project.DemoProject.repository.AccountholdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountholdersService {

    @Autowired
    private AccountholdersRepository repository;

    public List<Accountholders> getAllAccountholders() {
        return repository.findAll();
    }

    public Optional<Accountholders> getAccountholderById(Long id) {
        return repository.findById(id);
    }

    public Accountholders saveAccountholder(Accountholders accountholders) {
        return repository.save(accountholders);
    }

    public void deleteAccountholder(Long id) {
        repository.deleteById(id);
    }
}
