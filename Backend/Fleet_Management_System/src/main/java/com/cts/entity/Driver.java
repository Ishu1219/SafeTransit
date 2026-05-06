package com.cts.entity;
import com.cts.enums.DriverStatus;
import com.cts.enums.Sex;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
//import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Driver")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Sex sex;
    
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(length = 10)
    private String phone;

    @Column(name="licence")
    private String licence;

    @Column(length = 10)
    private String emergencyContact;

    @Column(length = 100)
    private String address;

    @Column(length = 5)
    private String bloodGroup;
 
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private DriverStatus status;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
    
}
