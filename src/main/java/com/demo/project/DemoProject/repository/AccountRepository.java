package com.demo.project.DemoProject.repository;

import com.demo.project.DemoProject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {}
