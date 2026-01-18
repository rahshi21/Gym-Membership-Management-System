package com.ms.dto.response;

import java.time.LocalDateTime;

import com.ms.enums.Goal;
import com.ms.enums.MembershipLevel;
import com.ms.enums.MembershipPlanStatus;

public class MembershipPlanResponse {

	private Long id;
	private MembershipLevel membershipLevel;
	private Integer durationOfMembershipPlan;
	private Goal goal;
	private Double price;
	private String description;
	private MembershipPlanStatus active;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public MembershipPlanResponse() {
		super();
	}

	public MembershipPlanResponse(Long id, MembershipLevel membershipLevel, Integer durationOfMembershipPlan, Goal goal,
			Double price, String description, MembershipPlanStatus active, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.membershipLevel = membershipLevel;
		this.durationOfMembershipPlan = durationOfMembershipPlan;
		this.goal = goal;
		this.price = price;
		this.description = description;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
