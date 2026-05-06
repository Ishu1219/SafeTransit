package com.cts.dto.request;
import com.cts.enums.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class UpdateAdminRequest 
{    
	@NotBlank(message = "Name cannot be blank")   
    @Size(max = 50, message = "Name cannot exceed 50 characters")    
	private String name;    
	@NotBlank(message = "Email cannot be blank")    
	@Email(message = "Invalid email format")    
	private String email;    
	@NotBlank(message = "Password cannot be blank")    
	@Size(min = 8, message = "Password must be at least 8 characters")    
	private String password;    
	@NotBlank(message = "Phone cannot be blank")    
	@Size(min = 10, max = 10, message = "Phone must be exactly 10 digits")    
	private String phone;   
	@NotBlank(message = "Emergency contact cannot be blank")    
	@Size(min = 10, max = 10, message = "Emergency contact must be exactly 10 digits")    
	private String emergencyContact;   
	@NotBlank(message = "Address cannot be blank")    
	private String address;    @NotBlank(message = "Blood group cannot be blank")    
	private String bloodGroup;    @NotNull(message = "Sex cannot be null")   
	private Sex sex;
	}