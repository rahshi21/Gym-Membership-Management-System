package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.response.DietPlanResponse;
import com.gm.entity.DietPlan;

@Component
public class DietPlanMapper {
	
    public DietPlanResponse toResponse(DietPlan plan) {

        DietPlanResponse response = new DietPlanResponse();
        response.setId(plan.getId());
        response.setMemberId(plan.getMember().getId());
        response.setTrainerId(plan.getTrainer().getId());
        response.setDescriptionOfDiet(plan.getDescriptionOfDiet());
        response.setPreferencesInDiet(plan.getPreferencesInDiet());
        response.setStatusOfDiet(plan.getStatusOfDiet());
        response.setCreatedAt(LocalDateTime.now());
        response.setCreatedAt(LocalDateTime.now());

        return response;
    }
}

