package com.ms.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ms.enums.Goal;
import com.ms.enums.MembershipLevel;
import com.ms.enums.MembershipPlanStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MembershipLevel membershipLevel;

    private Integer durationOfMembershipPlan;

    @Enumerated(EnumType.STRING)
    private Goal goal;

    private Double price;

    private String description;

    @Enumerated(EnumType.STRING)
    private MembershipPlanStatus active;

    @CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;

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

	public MembershipPlan() {
		super();
	}

	public MembershipPlan(Long id, MembershipLevel membershipLevel, Integer durationOfMembershipPlan, Goal goal,
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
	
	

    
}
