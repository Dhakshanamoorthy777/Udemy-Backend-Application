// ==========================
// User.java
// ==========================
package com.backend.Udemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email(message = "Enter Valid Email")
	@NotBlank(message = "Email is Required")
	private String email;

	@NotBlank(message = "Password is Required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;

	@Column(name = "full_name")
	@NotBlank(message = "Full Name is Required")
	private String fullName;

	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Role is Required")
	private Role role;

	@OneToMany(mappedBy = "instructor")
	private List<Course> courses;
}