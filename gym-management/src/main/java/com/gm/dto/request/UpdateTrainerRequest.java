package com.gm.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UpdateTrainerRequest {
	
	@Min(value = 1, message = "Trainer Id is required")
	private Long id;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;
    
	@NotBlank(message = "Availability is mandatory")
	private String availability;

	public UpdateTrainerRequest() {
		super();
	}

	

	public UpdateTrainerRequest(Long id, String email,String phone, String availability) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.availability = availability;
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
