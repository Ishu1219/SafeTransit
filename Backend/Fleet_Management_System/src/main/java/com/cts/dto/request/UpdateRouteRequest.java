package com.cts.dto.request;
import java.util.List;

import com.cts.enums.RouteStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRouteRequest { 
	@Size(max = 50, message = "Route name cannot exceed 50 characters")    
	private String routeName;    
	
	@Size(min = 2, message = "Route must have at least 2 stops")    
	private List<String> routeStops;  
	
	private int distanceKm;
	
	private RouteStatus status;
	
}