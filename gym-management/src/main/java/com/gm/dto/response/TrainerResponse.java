package com.gm.dto.response;

import java.time.LocalDateTime;

import com.gm.enums.Goal;

public class TrainerResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Integer experience;
	private Goal expertise;
	private String availability;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public TrainerResponse() {
		super();
	}

	public TrainerResponse(Long id, String firstName, String lastName, String email, String phone,
			Integer experience, Goal expertise, String availability, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.experience = experience;
		this.expertise = expertise;
		this.availability = availability;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Goal getExpertise() {
		return expertise;
	}

	public void setExpertise(Goal expertise) {
		this.expertise = expertise;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
