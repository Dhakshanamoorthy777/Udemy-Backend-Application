package com.backend.Udemy.dto;

import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
	
	@Email(message = "Enter Valid Email")
    @NotBlank(message = "Email is Required")
    private String email;
	
	@NotBlank(message = "Password is Required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}