package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.request.CreateDietPlanRequest;
import com.gm.dto.response.DietPlanResponse;
import com.gm.entity.DietPlan;
import com.gm.entity.Member;
import com.gm.entity.Trainer;
import com.gm.enums.DietPlanStatus;

@Component
public class DietPlanMapper {

    public DietPlan toEntity(CreateDietPlanRequest request,
                                    Member member,
                                    Trainer trainer) {

        DietPlan plan = new DietPlan();
        plan.setMember(member);
        plan.setTrainer(trainer);
        plan.setDescriptionOfDiet(request.getDescriptionOfDiet());
        plan.setPreferencesInDiet(request.getPreferencesInDiet());
        plan.setStatusOfDiet(DietPlanStatus.ACTIVE);
        plan.setCreatedAt(LocalDateTime.now());

        return plan;
    }

    public DietPlanResponse toResponse(DietPlan plan) {

        DietPlanResponse response = new DietPlanResponse();
        response.setId(plan.getId());
        response.setMemberId(plan.getMember().getId());
        response.setTrainerId(plan.getTrainer().getId());
        response.setDescriptionOfDiet(plan.getDescriptionOfDiet());
        response.setPreferencesInDiet(plan.getPreferencesInDiet());
        response.setStatusOfDiet(plan.getStatusOfDiet());

        return response;
    }
}

