package com.cts.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cts.enums.AuditAction;
import com.cts.enums.Sex;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PassengerID")
    private Long passengerId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 10)
    private String phone;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Sex sex;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private AuditAction status;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
    
    @OneToMany(mappedBy="passenger",cascade=CascadeType.ALL)
    private List<PassengerReport> passengerReports = new ArrayList<>();
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

}