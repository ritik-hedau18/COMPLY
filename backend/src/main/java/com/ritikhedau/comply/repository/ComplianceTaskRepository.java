package com.ritikhedau.comply.repository;

import com.ritikhedau.comply.entity.ComplianceTask;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ComplianceTaskRepository extends JpaRepository<ComplianceTask, Long> {
    List<ComplianceTask> findByCompanyId(Long companyId);
    List<ComplianceTask> findByCompanyIdIn(List<Long> companyIds);
    List<ComplianceTask> findByStatusAndDueDateBefore(String status, LocalDate date);
// minor tweak: performance check updates
}
