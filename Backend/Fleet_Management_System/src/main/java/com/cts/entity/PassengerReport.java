package com.cts.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cts.enums.AuditAction;

@Entity
@Table(name = "PassengerReport")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "PassengerID", nullable = false)
    private Passenger passenger;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column
    private Long scheduleId;

    private String category;
    @Enumerated(EnumType.STRING)
    private AuditAction status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    
}