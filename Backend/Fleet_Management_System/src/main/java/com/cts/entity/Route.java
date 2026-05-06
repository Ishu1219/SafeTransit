package com.cts.entity;

import java.time.Instant;
//import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cts.enums.RouteStatus;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Route_ID")
	private int routeId;
	@Column(name="Name",nullable = false, length = 50)
	private String routeName;

@ElementCollection

    @CollectionTable(
    		
        name = "Stops",
        joinColumns = @JoinColumn(name = "route_id")
    )
    @Column(name = "Stops")
    private List<String> routeStops;
    @Column(name="Distance",nullable = false, length = 50)
	private int distanceKm;
	 @Enumerated(EnumType.STRING)  
	 @Column(name="Status",length = 50)
	    private RouteStatus routeStatus;
	 @CreationTimestamp
	    private Instant createdAt;

	    @UpdateTimestamp
	    private Instant updatedAt;
}
