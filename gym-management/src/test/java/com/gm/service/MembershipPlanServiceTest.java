package com.gm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.gm.dto.request.CreateMembershipPlanRequest;
import com.gm.dto.request.UpdateMembershipPlanRequest;
import com.gm.dto.response.MembershipPlanResponse;
import com.gm.entity.MembershipPlan;
import com.gm.enums.MembershipPlanStatus;
import com.gm.exception.MembershipPlanNotFoundException;
import com.gm.repository.MembershipPlanRepository;

@SpringBootTest
@Transactional
class MembershipPlanServiceTest {

	@Autowired
	private MembershipPlanService membershipPlanService;

	@Autowired
	private MembershipPlanRepository membershipPlanRepository;

	@BeforeEach
	void setup() {
		membershipPlanRepository.deleteAll();
	}

	@Test
	void testAddMembership_success() {
		CreateMembershipPlanRequest request = new CreateMembershipPlanRequest();
		request.setDurationOfMembershipPlan(3);
		request.setPrice(Double.valueOf(1500));
		request.setDescription("3 Months Plan");
		request.setActive(MembershipPlanStatus.ACTIVE);

		MembershipPlanResponse response = membershipPlanService.addMembership(request);

		assertNotNull(response);
		assertEquals(3, response.getDurationOfMembershipPlan());
		assertEquals(Double.valueOf(1500), response.getPrice());
		assertEquals(MembershipPlanStatus.ACTIVE, response.getActive());
	}

	@Test
	void testUpdateMembership_success() {
		MembershipPlan plan = new MembershipPlan();
		plan.setDurationOfMembershipPlan(1);
		plan.setPrice(Double.valueOf(500));
		plan.setDescription("Monthly Plan");
		plan.setActive(MembershipPlanStatus.ACTIVE);

		MembershipPlan saved = membershipPlanRepository.save(plan);

		UpdateMembershipPlanRequest request = new UpdateMembershipPlanRequest();
		request.setId(saved.getId());
		request.setDurationOfMembershipPlan(6);
		request.setPrice(Double.valueOf(2500));
		request.setDescription("6 Months Plan");

		MembershipPlanResponse response = membershipPlanService.updateMembership(request);

		assertEquals(6, response.getDurationOfMembershipPlan());
		assertEquals(Double.valueOf(2500), response.getPrice());
		assertEquals("6 Months Plan", response.getDescription());
	}

	@Test
	void testUpdateMembership_notFound() {
		UpdateMembershipPlanRequest request = new UpdateMembershipPlanRequest();
		request.setId(999L);

		assertThrows(MembershipPlanNotFoundException.class, () -> membershipPlanService.updateMembership(request));
	}

	@Test
	void testGetMembershipById_success() {
		MembershipPlan plan = new MembershipPlan();
		plan.setDurationOfMembershipPlan(12);
		plan.setPrice(Double.valueOf(8000));
		plan.setDescription("Annual Plan");

		MembershipPlan saved = membershipPlanRepository.save(plan);

		MembershipPlanResponse response = membershipPlanService.getMembershipById(saved.getId());

		assertEquals(12, response.getDurationOfMembershipPlan());
		assertEquals(Double.valueOf(8000), response.getPrice());
	}

	@Test
	void testGetMembershipById_notFound() {
		assertThrows(MembershipPlanNotFoundException.class, () -> membershipPlanService.getMembershipById(1000L));
	}

	@Test
	void testGetActiveMemberships_success() {
		MembershipPlan activePlan = new MembershipPlan();
		activePlan.setDurationOfMembershipPlan(3);
		activePlan.setActive(MembershipPlanStatus.ACTIVE);

		MembershipPlan inactivePlan = new MembershipPlan();
		inactivePlan.setDurationOfMembershipPlan(6);
		inactivePlan.setActive(MembershipPlanStatus.INACTIVE);

		membershipPlanRepository.save(activePlan);
		membershipPlanRepository.save(inactivePlan);

		List<MembershipPlanResponse> activePlans = membershipPlanService.getActiveMemberships();

		assertEquals(1, activePlans.size());
		assertEquals(MembershipPlanStatus.ACTIVE, activePlans.get(0).getActive());
	}
}
