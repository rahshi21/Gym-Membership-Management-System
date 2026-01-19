package com.gm.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UpdateDietPlanRequest {
	
	@Min(value = 1, message = "Diet Plan ID must be valid")
    private Long id;
	
	@NotBlank(message = "Description of Diet is mandatory")
    private String descriptionOfDiet;
    
	@NotBlank(message = "Member Preference in Diet is mandatory")
    private String preferencesInDiet;

	public UpdateDietPlanRequest() {
		super();
	}

	public UpdateDietPlanRequest(Long id, String descriptionOfDiet, String preferencesInDiet) {
		super();
		this.id = id;
		this.descriptionOfDiet = descriptionOfDiet;
		this.preferencesInDiet = preferencesInDiet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
