package com.demo.project.DemoProject.services;

import com.demo.project.DemoProject.entity.Transactions;
import com.demo.project.DemoProject.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository repository;

    public List<Transactions> getAllTransactions() {
        return repository.findAll();
    }

    public Optional<Transactions> getTransactionById(Long id) {
        return repository.findById(id);
    }

    public Transactions saveTransaction(Transactions transaction) {
        return repository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
