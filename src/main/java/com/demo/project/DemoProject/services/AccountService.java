package com.demo.project.DemoProject.services;

import com.demo.project.DemoProject.entity.Account;
import com.demo.project.DemoProject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return repository.findById(id);
    }

    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
