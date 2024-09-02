package com.demo.project.DemoProject.repository;

import com.demo.project.DemoProject.entity.Accountholders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountholdersRepository extends JpaRepository<Accountholders, Long> {
}
