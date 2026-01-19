package com.gm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.dto.request.CreateMembershipPlanRequest;
import com.gm.dto.request.UpdateMembershipPlanRequest;
import com.gm.dto.response.MembershipPlanResponse;
import com.gm.entity.MembershipPlan;
import com.gm.enums.MembershipPlanStatus;
import com.gm.exception.MembershipPlanNotFoundException;
import com.gm.mapper.MembershipPlanMapper;
import com.gm.repository.MembershipPlanRepository;

@Service
public class MembershipPlanService {

	Logger logger = LoggerFactory.getLogger(MembershipPlanService.class);

	@Autowired
	private MembershipPlanRepository memberRepo;

	@Autowired
	private MembershipPlanMapper mapper;

	public MembershipPlanResponse addMembership(CreateMembershipPlanRequest request) {
		MembershipPlan member = mapper.toEntity(request);
		MembershipPlan saved = memberRepo.save(member);
		MembershipPlanResponse response = mapper.toResponse(saved);
		return response;
	}

	public MembershipPlanResponse updateMembership(UpdateMembershipPlanRequest request) {
		MembershipPlan plan = memberRepo.findById(request.getId()).orElseThrow(
				// creating a custom exception
				() -> new MembershipPlanNotFoundException("This membership plan id does not exist"));

		plan.setDurationOfMembershipPlan(request.getDurationOfMembershipPlan());
		plan.setPrice(request.getPrice());
		plan.setActive(request.getActive());

		MembershipPlan saved = memberRepo.save(plan);
		logger.info(saved.toString());
		MembershipPlanResponse response = mapper.toResponse(saved);

		return response;
	}

	public MembershipPlanResponse getMembershipById(Long id) {
		logger.info("Get Membership Plan by id : " + id);
		MembershipPlan member = memberRepo.findById(id).orElseThrow(() -> new RuntimeException("Plan not found"));
		MembershipPlanResponse response = mapper.toResponse(member);
		return response;
	}

	public List<MembershipPlanResponse> getAllMemberships() {
		return memberRepo
				.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
	}

	public List<MembershipPlanResponse> getActiveMemberships() {

		List<MembershipPlan> activePlans = memberRepo.findByStatus(MembershipPlanStatus.ACTIVE);
		List<MembershipPlanResponse> responseList = new ArrayList<>();

		for (MembershipPlan membership : activePlans) {
			responseList.add(mapper.toResponse(membership));
		}

		return responseList;
	}

}
