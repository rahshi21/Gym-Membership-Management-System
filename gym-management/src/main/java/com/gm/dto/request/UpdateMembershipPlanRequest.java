package com.gm.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UpdateMembershipPlanRequest {
	
	@Min(value = 1, message = "Membership Plan Id is required")
	private Long id;

    @NotNull(message = "Duration of membership is required")
    @Min(value = 1, message = "Duration of membership must be at least one month")
    private Integer durationOfMembershipPlan;

    @NotNull(message = "Price is mandatory")
	@Positive(message = "price must be greater than zero")
    private Double price;
    
    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 100, message = "Description must be between 10 to 20 characters")
    private String description;

	public UpdateMembershipPlanRequest() {
		super();
	}

	public UpdateMembershipPlanRequest(Long id, Integer durationOfMembershipPlan, Double price, String description) {
		super();
		this.id = id;
		this.durationOfMembershipPlan = durationOfMembershipPlan;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDurationOfMembershipPlan() {
		return durationOfMembershipPlan;
	}

	public void setDurationOfMembershipPlan(Integer durationOfMembershipPlan) {
		this.durationOfMembershipPlan = durationOfMembershipPlan;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
