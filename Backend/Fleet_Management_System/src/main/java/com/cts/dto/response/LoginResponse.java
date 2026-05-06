package com.cts.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

	 private String token;
	    private String role;
	    private String email;
	    private String name;
	    private Long   userId;
	    private long   expiresInSeconds;

}
