package com.cts.entity;

import com.cts.enums.DriverAssignmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignId;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    
    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    
    @ManyToOne
    @JoinColumn(name = "assigned_by", nullable = false)
    private Dispatcher assignedBy;

    private LocalDateTime assignedAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private DriverAssignmentStatus status;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}