package com.cts.entity;

import com.cts.enums.ReportingPeriod;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@Entity
@Table(name = "KPI")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kpiId;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 500)
    private String definition;

    private Double target;

    private Double currentValue;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ReportingPeriod reportingPeriod;

   
    private Long operationsManagerId;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
