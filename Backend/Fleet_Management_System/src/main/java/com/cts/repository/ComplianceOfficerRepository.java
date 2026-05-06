package com.cts.repository;

import com.cts.entity.ComplianceOfficer; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceOfficerRepository extends JpaRepository<ComplianceOfficer, Long> {

   
    ComplianceOfficer findByEmail(String email);

    ComplianceOfficer findByOfficerId(Long officerId);
}
