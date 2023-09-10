package com.example.demo.repositories;

import com.example.demo.entities.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CaseRepository extends JpaRepository<CaseEntity, Long> {
}
