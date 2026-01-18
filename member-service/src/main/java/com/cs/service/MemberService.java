package com.cs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.dto.request.CreateMemberRequest;
import com.cs.dto.response.DietPlanResponse;
import com.cs.dto.response.EquipmentBookingResponse;
import com.cs.dto.response.MemberResponse;
import com.cs.dto.response.MembershipPlanResponse;
import com.cs.dto.response.RatingResponse;
import com.cs.dto.response.TrainerResponse;
import com.cs.entity.Member;
import com.cs.entity.User;
import com.cs.exception.MemberNotFoundException;
import com.cs.feignclients.DietPlanFeignClient;
import com.cs.feignclients.EquipmentBookingFeignClient;
import com.cs.feignclients.MembershipFeignClient;
import com.cs.feignclients.RatingFeignClient;
import com.cs.feignclients.TrainerFeignClient;
import com.cs.mapper.MemberMapper;
import com.cs.repository.MemberRepository;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private MembershipFeignClient membershipFeignClient;
	
	@Autowired
	private TrainerFeignClient trainerFeignClient;
	
	@Autowired
	private DietPlanFeignClient dietPlanFeignClient;
	
	@Autowired
	private EquipmentBookingFeignClient equipmentBookingFeignClient;
	
	@Autowired
	private RatingFeignClient ratingFeignClient;
	
	public MembershipPlanResponse getPlan(@PathVariable Long id) {
		ResponseEntity<MembershipPlanResponse> response = membershipFeignClient.getPlan(id);
		return response.getBody();
	}
	
	public TrainerResponse getTrainer(@PathVariable Long id) {
		ResponseEntity<TrainerResponse> response = trainerFeignClient.getTrainer(id);
		return response.getBody();
	}
	
	public DietPlanResponse getDietPlan(@PathVariable Long id) {
		ResponseEntity<DietPlanResponse> response = dietPlanFeignClient.getDietPlan(id);
		return response.getBody();
	}
	
	public EquipmentBookingResponse getBooking(@PathVariable Long id) {
		ResponseEntity<EquipmentBookingResponse> response = equipmentBookingFeignClient.getBooking(id);
		return response.getBody();
	}
	
	public RatingResponse getRating(@PathVariable Long id) {
		ResponseEntity<RatingResponse> response = ratingFeignClient.getRating(id);
		return response.getBody();
	}
	
	public MemberResponse createMember(CreateMemberRequest request) {
		Member member = mapper.toEntity(request);
		Member saved = memberRepo.save(member);
		MemberResponse response = mapper.toResponse(saved);
		response.setPlan(getPlan(saved.getPlanId()));
		return response;
	}
	
	public MemberResponse getMyProfile(User user) {
		Member member = memberRepo.findByUsername(user.getUsername())
				.orElseThrow(() ->
						new MemberNotFoundException("Member not found : " + user.getUsername())
						);
		
		MemberResponse response = mapper.toResponse(member);
		response.setPlan(getPlan(member.getPlanId()));
		return response;
	}
	
	public MemberResponse getMemberById(Long id) {
		logger.info("Get Member by id : " + id);
		Member member = memberRepo.findById(id).orElseThrow(
					() -> new RuntimeException("Member not found")
				);
		MemberResponse response = mapper.toResponse(member);
		response.setPlan(getPlan(member.getPlanId()));
		return response;
	}

	public List<MemberResponse> getAllMembers() {
		return memberRepo.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
	}

	
	

}
