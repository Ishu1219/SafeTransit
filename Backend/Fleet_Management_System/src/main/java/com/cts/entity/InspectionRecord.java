package com.cts.entity;

import jakarta.persistence.*; 
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.cts.enums.InspectionRecordStatus;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "InspectionRecord")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InspectionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inspectionId;

    @Column(nullable = false)
    private Long vehicleId;

    @ManyToOne
    @JoinColumn(name = "inspector_id", nullable = false)
    private ComplianceOfficer inspector;

    @Column(nullable = false)
    private LocalDate performedAt;

    @Column
    private Integer conditionRating; 

    @Column(columnDefinition = "TEXT")
    private String findings;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private InspectionRecordStatus status; 

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
