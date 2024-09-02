package com.demo.project.DemoProject.repository;
import com.demo.project.DemoProject.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customers, Long> {}
