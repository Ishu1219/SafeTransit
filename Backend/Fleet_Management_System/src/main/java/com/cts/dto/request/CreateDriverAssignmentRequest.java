package com.cts.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDriverAssignmentRequest {
	@NotNull(message = "driverId is required")
	@Positive(message = "driverId must be a positive number")
	private Long driverId;

	@NotNull(message = "vehicleId is required")
	@Positive(message = "vehicleId must be a positive number")
	private Long vehicleId;

	@NotNull(message = "routeId is required")
	@Positive(message = "routeId must be a positive number")
	private Integer routeId;

	@NotNull(message = "dispatcherId is required")
	@Positive(message = "dispatcherId must be a positive number")
	private Long dispatcherId;
}