package com.ms.dto.request;

import com.ms.enums.Goal;
import com.ms.enums.MembershipLevel;
import com.ms.enums.MembershipPlanStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class CreateMembershipPlanRequest {
	
	@NotBlank(message = "Membership Level is required")
    private MembershipLevel membershipLevel;

    @NotNull(message = "Duration of membership is required")
    @Min(value = 1, message = "Duration of membership must be at least one month")
    private Integer durationOfMembershipPlan;

    @NotBlank(message = "Goal is required")
    private Goal goal;

    @NotNull(message = "Price is mandatory")
	@PositiveOrZero(message = "price must be greater than or equal to zero")
    private Double price;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 100, message = "Description must be between 10 to 20 characters")
    private String description;

    @NotBlank(message = "Membership Plan Status is required")
    private MembershipPlanStatus active;

	public CreateMembershipPlanRequest() {
		super();
	}

	public CreateMembershipPlanRequest(MembershipLevel membershipLevel, Integer durationOfMembershipPlan, Goal goal, Double price, String description, MembershipPlanStatus active) {
		super();
		this.membershipLevel = membershipLevel;
		this.durationOfMembershipPlan = durationOfMembershipPlan;
		this.goal = goal;
		this.price = price;
		this.description = description;
		this.active = active;
	}

	public MembershipLevel getMembershipLevel() {
		return membershipLevel;
	}

	public void setMembershipLevel(MembershipLevel membershipLevel) {
		this.membershipLevel = membershipLevel;
	}

	public Integer getDurationOfMembershipPlan() {
		return durationOfMembershipPlan;
	}

	public void setDurationOfMembershipPlan(Integer durationOfMembershipPlan) {
		this.durationOfMembershipPlan = durationOfMembershipPlan;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
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

	public MembershipPlanStatus getActive() {
		return active;
	}

	public void setActive(MembershipPlanStatus active) {
		this.active = active;
	}
    
    

}
