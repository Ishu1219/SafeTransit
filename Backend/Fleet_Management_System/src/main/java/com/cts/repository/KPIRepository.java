package com.cts.repository;

import com.cts.entity.KPI;
import com.cts.enums.ReportingPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KPIRepository extends JpaRepository<KPI, Long> {

    KPI findByKpiId(Long kpiId);

    List<KPI> findByOperationsManagerId(Long operationsManagerId);

    List<KPI> findByReportingPeriod(ReportingPeriod reportingPeriod);
}