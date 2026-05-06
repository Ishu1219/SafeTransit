package com.cts.dto.response;
import java.util.List;

import com.cts.enums.RouteStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteResponseDTO {

	private int routeId;
	private String routeName;
	private List<String> routeStops;
	private int distanceKm;
	private RouteStatus routeStatus;
}
