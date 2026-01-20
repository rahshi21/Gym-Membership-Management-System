package com.gm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.dto.request.CreateDietPlanRequest;
import com.gm.dto.request.UpdateDietPlanRequest;
import com.gm.dto.response.DietPlanResponse;
import com.gm.entity.DietPlan;
import com.gm.entity.Member;
import com.gm.entity.Trainer;
import com.gm.enums.DietPlanStatus;
import com.gm.exception.DietPlanNotFoundException;
import com.gm.exception.MemberNotFoundException;
import com.gm.exception.TrainerNotFoundException;
import com.gm.mapper.DietPlanMapper;
import com.gm.repository.DietPlanRepository;
import com.gm.repository.MemberRepository;
import com.gm.repository.TrainerRepository;

@Service
public class DietPlanService {
	
	Logger logger = LoggerFactory.getLogger(DietPlanService.class);

	@Autowired
	private DietPlanRepository dietPlanRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private TrainerRepository trainerRepository;
	
	@Autowired
	private DietPlanMapper mapper;

	public DietPlanResponse createDietPlan(CreateDietPlanRequest request) {

		Member member = memberRepository.findById(request.getMemberId())
				.orElseThrow(() -> new MemberNotFoundException("Member not found"));

		Trainer trainer = trainerRepository.findById(request.getTrainerId())
				.orElseThrow(() -> new TrainerNotFoundException("Trainer not found"));

		// Inactivate existing active plan
        dietPlanRepository
                .findByMemberIdAndStatusOfDiet(member.getId(), DietPlanStatus.ACTIVE)
                .ifPresent(plan -> {
                    plan.setStatusOfDiet(DietPlanStatus.INACTIVE);
                    plan.setUpdatedAt(LocalDateTime.now());
                    dietPlanRepository.save(plan);
                });

        DietPlan newPlan = new DietPlan();
        newPlan.setMember(member);
        newPlan.setTrainer(trainer);
        newPlan.setDescriptionOfDiet(request.getDescriptionOfDiet());
        newPlan.setPreferencesInDiet(request.getPreferencesInDiet());
        newPlan.setStatusOfDiet(DietPlanStatus.ACTIVE);
        newPlan.setCreatedAt(LocalDateTime.now());
        newPlan.setUpdatedAt(LocalDateTime.now());
		DietPlan saved = dietPlanRepository.save(newPlan);

		return mapper.toResponse(saved);
	}

	public DietPlanResponse updateDietPlanContent(UpdateDietPlanRequest request) {

		DietPlan plan = dietPlanRepository.findById(request.getId())
				.orElseThrow(() -> new DietPlanNotFoundException("Diet plan not found"));

		if (request.getDescriptionOfDiet() != null) {
			plan.setDescriptionOfDiet(request.getDescriptionOfDiet());
		}

		if (request.getPreferencesInDiet() != null) {
			plan.setPreferencesInDiet(request.getPreferencesInDiet());
		}

		plan.setUpdatedAt(LocalDateTime.now());

		return mapper.toResponse(dietPlanRepository.save(plan));
	}

	public DietPlanResponse getActiveDietPlanForCustomer(Long memberId) {

		DietPlan plan = dietPlanRepository.findByMemberIdAndStatusOfDiet(memberId, DietPlanStatus.ACTIVE)
				.orElseThrow(() -> new DietPlanNotFoundException("No active diet plan"));

		return mapper.toResponse(plan);
	}

	public List<DietPlanResponse> getDietPlansByTrainer(Long trainerId) {

		List<DietPlan> plans = dietPlanRepository.findByTrainerId(trainerId);
		List<DietPlanResponse> responses = new ArrayList<>();

		for (DietPlan plan : plans) {
			responses.add(mapper.toResponse(plan));
		}

		return responses;
	}
}
