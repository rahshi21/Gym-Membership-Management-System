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

	// TRAINER → Create diet plan
	public DietPlanResponse createDietPlan(CreateDietPlanRequest request) {

		Member member = memberRepository.findById(request.getMember().getId())
				.orElseThrow(() -> new MemberNotFoundException("Member not found"));

		Trainer trainer = trainerRepository.findById(request.getTrainer().getId())
				.orElseThrow(() -> new TrainerNotFoundException("Trainer not found"));

		dietPlanRepository.findByCustomerIdAndStatusOfDiet(member.getId(), DietPlanStatus.ACTIVE)
		.ifPresent(plan -> {
			plan.setStatusOfDiet(DietPlanStatus.INACTIVE);
			plan.setUpdatedAt(LocalDateTime.now());
			dietPlanRepository.save(plan);
		});

		DietPlan newPlan = mapper.toEntity(request, member, trainer);
		DietPlan saved = dietPlanRepository.save(newPlan);

		return mapper.toResponse(saved);
	}

	// TRAINER → Update content
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

	// MEMBER → View active plan
	public DietPlanResponse getActiveDietPlanForCustomer(Long memberId) {

		DietPlan plan = dietPlanRepository.findByCustomerIdAndStatusOfDiet(memberId, DietPlanStatus.ACTIVE)
				.orElseThrow(() -> new DietPlanNotFoundException("No active diet plan"));

		return mapper.toResponse(plan);
	}

	// TRAINER → View history
	public List<DietPlanResponse> getDietPlansByTrainer(Long trainerId) {

		List<DietPlan> plans = dietPlanRepository.findByTrainerId(trainerId);
		List<DietPlanResponse> responses = new ArrayList<>();

		for (DietPlan plan : plans) {
			responses.add(mapper.toResponse(plan));
		}

		return responses;
	}
}
