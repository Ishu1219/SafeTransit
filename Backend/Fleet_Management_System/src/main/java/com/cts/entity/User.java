package com.cts.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cts.enums.Role;
//import com.cts.enums.Status;
import com.cts.enums.UserStatus;

import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder
@Entity
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
	
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;
    
    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    
    @UpdateTimestamp
    private Instant updatedAt;
    
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private ComplianceOfficer complianceOfficer;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Dispatcher dispatcher;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Driver driver;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private FleetManager fleetManager;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private OperationsManager operationsManager;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Passenger passenger;
    
    
}
