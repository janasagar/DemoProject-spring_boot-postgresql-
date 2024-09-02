package com.demo.project.DemoProject.repository;

import com.demo.project.DemoProject.entity.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, Long> {
}