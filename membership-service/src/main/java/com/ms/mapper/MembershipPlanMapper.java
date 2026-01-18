package com.ms.mapper;

import org.springframework.stereotype.Component;

import com.ms.dto.request.CreateMembershipPlanRequest;
import com.ms.dto.response.MembershipPlanResponse;
import com.ms.entity.MembershipPlan;

@Component
public class MembershipPlanMapper {
	
	public MembershipPlan toEntity(CreateMembershipPlanRequest req) {
		MembershipPlan plan = new MembershipPlan();
		plan.setMembershipLevel(req.getMembershipLevel());
		plan.setDurationOfMembershipPlan(req.getDurationOfMembershipPlan());
		plan.setGoal(req.getGoal());
		plan.setPrice(req.getPrice());
		plan.setDescription(req.getDescription());
		plan.setActive(req.getActive());
		
		return plan;
	}
	
	public MembershipPlanResponse toResponse(MembershipPlan plan) {
		return new MembershipPlanResponse(
					plan.getId(),
					plan.getMembershipLevel(),
					plan.getDurationOfMembershipPlan(),
					plan.getGoal(),
					plan.getPrice(),
					plan.getDescription(),
					plan.getActive(),
					plan.getCreatedAt(),
					plan.getUpdatedAt()
				);
	}

}
