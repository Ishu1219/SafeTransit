
package com.cts.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.cts.enums.ComplainceOfficer;
import com.cts.enums.Sex;
import java.time.Instant;

@Entity
@Table(name = "ComplianceOfficer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceOfficer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officerId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(length = 20)
    private String phone;
    
    @Column(length=20)
    private String emergencycontact;
    
    @Column(length=255)
    private String password;
    
    @Column(length=20)
    private String bloodgroup;
    
     @Column(length=50)
     private String address;
     
     @Enumerated(EnumType.STRING)
     @Column(length = 10)
     private Sex sex;
    
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private ComplainceOfficer status; 

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
