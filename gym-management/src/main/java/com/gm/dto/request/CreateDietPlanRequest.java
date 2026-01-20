package com.gm.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDietPlanRequest {
	
	@NotNull(message = "Member Id is mandatory")
	private Long memberId;

	@NotNull(message = "Trainer Id is mandatory")
    private Long trainerId;

	@NotBlank(message = "Description of Diet is mandatory")
    private String descriptionOfDiet;
    
	@NotBlank(message = "Member Preference in Diet is mandatory")
    private String preferencesInDiet;

	public CreateDietPlanRequest() {
		super();
	}

	public CreateDietPlanRequest(Long memberId, Long trainerId, String descriptionOfDiet, String preferencesInDiet) {
		super();
		this.memberId = memberId;
		this.trainerId = trainerId;
		this.descriptionOfDiet = descriptionOfDiet;
		this.preferencesInDiet = preferencesInDiet;
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

	

}
