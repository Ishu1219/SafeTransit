package com.cts.entity;

import com.cts.enums.OperationsManagerStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "OperationsManager")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationsManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationsManagerId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
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
    @Column(length = 50)
    private OperationsManagerStatus status;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user; 
}