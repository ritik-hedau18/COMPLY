package com.ritikhedau.comply.repository;

import com.ritikhedau.comply.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    List<NotificationLog> findByCompanyId(Long companyId);
// minor tweak: performance check updates
}
