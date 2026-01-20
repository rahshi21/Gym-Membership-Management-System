package com.gm.dto.request;

import com.gm.enums.MembershipPlanStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpdateMembershipPlanRequest {
	
	@Min(value = 1, message = "Membership Plan Id is required")
	private Long id;

    @NotNull(message = "Duration of membership is required")
    @Min(value = 1, message = "Duration of membership must be at least one month")
    private Integer durationOfMembershipPlan;

    @NotNull(message = "Price is mandatory")
	@Positive(message = "price must be greater than zero")
    private Double price;

    @NotNull(message = "Membership Plan Status is required")
    private MembershipPlanStatus active;

	public UpdateMembershipPlanRequest() {
		super();
	}

	public UpdateMembershipPlanRequest(Long id, Integer durationOfMembershipPlan, Double price, MembershipPlanStatus active) {
		super();
		this.id = id;
		this.durationOfMembershipPlan = durationOfMembershipPlan;
		this.price = price;
		this.active = active;
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

	public MembershipPlanStatus getActive() {
		return active;
	}

	public void setActive(MembershipPlanStatus active) {
		this.active = active;
	}

}
