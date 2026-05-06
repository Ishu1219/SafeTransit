package com.cts.entity;

import com.cts.enums.MaintenanceStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@Entity
@Table(name = "MaintenanceRecord")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintId;

    @ManyToOne
    @JoinColumn(name = "vehicleId", nullable = false)
    private Vehicle vehicle;

    @Column(nullable = false, length = 255)
    private String taskDescription;

    @Column(length = 100)
    private String performedBy;

    private Instant performedAt;

    private Double cost;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MaintenanceStatus status;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "fleet_manager_id")
    private FleetManager fleetManager; 
}