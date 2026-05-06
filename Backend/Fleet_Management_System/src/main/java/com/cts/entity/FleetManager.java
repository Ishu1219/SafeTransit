package com.cts.entity;

import com.cts.enums.FleetManagerStatus;
import com.cts.enums.Sex;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "FleetManager")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FleetManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fleetManagerId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(length = 10)
    private String phone;

    @Column(length = 10)
    private String emergencyContact;

    @Column(length = 100)
    private String address;

    @Column(length = 5)
    private String bloodGroup;

    
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private FleetManagerStatus status;

    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
    
    @OneToMany(mappedBy="fleetManager")
    private List<MaintenanceRecord> maintenanceRecord;
    
    @OneToMany(mappedBy="fleetManager")
    private List<MaintenancePlan> maintenancePlan;
}
