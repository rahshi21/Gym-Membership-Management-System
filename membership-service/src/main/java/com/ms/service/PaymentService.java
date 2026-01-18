package com.ms.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dto.response.PaymentResponse;
import com.ms.entity.MembershipPlan;
import com.ms.entity.Payment;
import com.ms.enums.PaymentStatus;
import com.ms.repository.MembershipPlanRepository;
import com.ms.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private MembershipPlanRepository planRepo;

	public PaymentResponse purchaseMembership(Long planId, Long customerId) {

		MembershipPlan plan = planRepo.findById(planId).orElseThrow(() -> new RuntimeException("Plan not found"));

		// Create payment (PENDING)
		Payment payment = new Payment();
		payment.setCustomerId(customerId);
		payment.setMembershipPlanId(planId);
		payment.setAmount(plan.getPrice());
		payment.setStatus(PaymentStatus.PENDING);

		paymentRepo.save(payment);

		// Simulate successful payment
		payment.setStatus(PaymentStatus.PAID);
		payment.setPaymentDate(LocalDateTime.now());

		paymentRepo.save(payment);

		return new PaymentResponse(
				payment.getId(), 
				payment.getCustomerId(),
				payment.getMembershipPlanId(),
				payment.getAmount(), 
				payment.getStatus(),
				payment.getPaymentDate()
				);
	}

}
