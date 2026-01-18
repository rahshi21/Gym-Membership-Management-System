package com.cs.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberResponse {
	
	private Long id;
	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private LocalDate dateOfBirth;
	private String address;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	private MembershipPlanResponse plan;
	private TrainerResponse trainer;
	private DietPlanResponse dietPlan;
	private EquipmentBookingResponse bookEquipment;
	private RatingResponse ratingResponse;
	
	public MemberResponse() {
		super();
	}

	public MemberResponse(Long id, String username, String firstName, String lastName, String email, String phone,
			LocalDate dateOfBirth, String address, LocalDateTime createdAt, LocalDateTime updatedAt,
			MembershipPlanResponse plan, TrainerResponse trainer, DietPlanResponse dietPlan,
			EquipmentBookingResponse bookEquipment, RatingResponse ratingResponse) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.plan = plan;
		this.trainer = trainer;
		this.dietPlan = dietPlan;
		this.bookEquipment = bookEquipment;
		this.ratingResponse = ratingResponse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public MembershipPlanResponse getPlan() {
		return plan;
	}

	public void setPlan(MembershipPlanResponse plan) {
		this.plan = plan;
	}

	public TrainerResponse getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerResponse trainer) {
		this.trainer = trainer;
	}

	public DietPlanResponse getDietPlan() {
		return dietPlan;
	}

	public void setDietPlan(DietPlanResponse dietPlan) {
		this.dietPlan = dietPlan;
	}

	public EquipmentBookingResponse getBookEquipment() {
		return bookEquipment;
	}

	public void setBookEquipment(EquipmentBookingResponse bookEquipment) {
		this.bookEquipment = bookEquipment;
	}

	public RatingResponse getRatingResponse() {
		return ratingResponse;
	}

	public void setRatingResponse(RatingResponse ratingResponse) {
		this.ratingResponse = ratingResponse;
	}
	
}
