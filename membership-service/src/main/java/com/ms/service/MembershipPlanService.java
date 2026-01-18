package com.ms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dto.request.CreateMembershipPlanRequest;
import com.ms.dto.response.MembershipPlanResponse;
import com.ms.entity.MembershipPlan;
import com.ms.mapper.MembershipPlanMapper;
import com.ms.repository.MembershipPlanRepository;

@Service
public class MembershipPlanService {
	
Logger logger = LoggerFactory.getLogger(MembershipPlanService.class);
	
	@Autowired
	private MembershipPlanRepository memberRepo;
	
	@Autowired
	private MembershipPlanMapper mapper;
	
	public MembershipPlanResponse createPlan(CreateMembershipPlanRequest request) {
		MembershipPlan member = mapper.toEntity(request);
		MembershipPlan saved = memberRepo.save(member);
		MembershipPlanResponse response = mapper.toResponse(saved);
		return response;
	}
	
	public MembershipPlanResponse getPlanById(Long id) {
		logger.info("Get Plan by id : " + id);
		MembershipPlan member = memberRepo.findById(id).orElseThrow(
					() -> new RuntimeException("Plan not found")
				);
		MembershipPlanResponse response = mapper.toResponse(member);
		return response;
	}

	public List<MembershipPlanResponse> getAllPlans() {
		return memberRepo.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
	}

}
