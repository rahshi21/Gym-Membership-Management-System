package com.gm.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.gm.enums.DietPlanStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class DietPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    private String descriptionOfDiet;
    private String preferencesInDiet;

    @Enumerated(EnumType.STRING)
    private DietPlanStatus statusOfDiet;

    @CreatedDate
	@Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

	public DietPlan() {
//		super();
	}

	public DietPlan(Long id, Member member, Trainer trainer, String descriptionOfDiet, String preferencesInDiet,
			DietPlanStatus statusOfDiet, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.member = member;
		this.trainer = trainer;
		this.descriptionOfDiet = descriptionOfDiet;
		this.preferencesInDiet = preferencesInDiet;
		this.statusOfDiet = statusOfDiet;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public String getDescriptionOfDiet() {
		return descriptionOfDiet;
	}

	public void setDescriptionOfDiet(String descriptionOfDiet) {
		this.descriptionOfDiet = descriptionOfDiet;
	}

	public String getPreferencesInDiet() {
		return preferencesInDiet;
	}

	public void setPreferencesInDiet(String preferencesInDiet) {
		this.preferencesInDiet = preferencesInDiet;
	}

	public DietPlanStatus getStatusOfDiet() {
		return statusOfDiet;
	}

	public void setStatusOfDiet(DietPlanStatus statusOfDiet) {
		this.statusOfDiet = statusOfDiet;
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