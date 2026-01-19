package com.gm.dto.response;

import java.time.LocalDateTime;

import com.gm.enums.DietPlanStatus;

public class DietPlanResponse {
	
	private Long id;
    private Long memberId;
    private Long trainerId;
    private String descriptionOfDiet;
    private String preferencesInDiet;
    private DietPlanStatus statusOfDiet;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    
	public DietPlanResponse() {
		super();
	}


	public DietPlanResponse(Long id, Long memberId, Long trainerId, String descriptionOfDiet, String preferencesInDiet,
			DietPlanStatus statusOfDiet, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.trainerId = trainerId;
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


	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public Long getTrainerId() {
		return trainerId;
	}


	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
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
