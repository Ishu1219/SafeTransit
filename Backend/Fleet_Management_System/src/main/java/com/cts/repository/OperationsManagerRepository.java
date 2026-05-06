package com.cts.repository;

import com.cts.entity.OperationsManager; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsManagerRepository
        extends JpaRepository<OperationsManager, Long> {

  
    
    OperationsManager findByEmail(String email);

   
    OperationsManager findByOperationsManagerId(Long operationsManagerId);
}
