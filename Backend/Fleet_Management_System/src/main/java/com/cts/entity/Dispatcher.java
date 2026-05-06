package com.cts.entity;

import com.cts.enums.AuditAction;
import com.cts.enums.Sex;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Dispatcher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dispatcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DispatcherID")
    private Long dispatcherId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

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
    private AuditAction status;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}