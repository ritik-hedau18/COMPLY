package com.ritikhedau.comply.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_tasks")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ComplianceTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String category; // GST, TDS, PF, ESI, FSSAI, SHOP_ACT

    @Column(nullable = false)
    private LocalDate dueDate;

    private String status; // PENDING, FILED, OVERDUE

    private Double estimatedPenalty;

    private LocalDate filedDate;

    private String remarks;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (estimatedPenalty == null) estimatedPenalty = 0.0;
        if (status == null) status = "PENDING";
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
