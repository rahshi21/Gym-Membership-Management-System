package com.gm.dto.request;

import com.gm.entity.Member;
import com.gm.entity.Trainer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDietPlanRequest {
	
	@NotNull(message = "Member Id is mandatory")
	private Member member;

	@NotNull(message = "Trainer Id is mandatory")
    private Trainer trainer;

	@NotBlank(message = "Description of Diet is mandatory")
    private String descriptionOfDiet;
    
	@NotBlank(message = "Member Preference in Diet is mandatory")
    private String preferencesInDiet;

	public CreateDietPlanRequest() {
		super();
	}

	public CreateDietPlanRequest(Member member, Trainer trainer, String descriptionOfDiet, String preferencesInDiet) {
		super();
		this.member = member;
		this.trainer = trainer;
		this.descriptionOfDiet = descriptionOfDiet;
		this.preferencesInDiet = preferencesInDiet;
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
	
	

}
