package com.riwi.simulacro.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.simulacro.domain.entities.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long>{
    
}
