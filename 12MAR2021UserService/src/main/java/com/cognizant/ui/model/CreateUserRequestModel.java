package com.cognizant.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CreateUserRequestModel {
	@NotNull(message = "first name required")
	@Size(min = 3,message = "first name must be 8 char long")
	private String firstName;
	@NotNull(message = "first name required")
	@Size(min = 3,message = "first name must be 8 char long")
	private String lastName;
	@Email(message = "invalid email")
	private String email;
	@NotNull
	private String password;

}