package com.gm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.dto.request.PurchaseMembershipRequest;
import com.gm.dto.response.PaymentResponse;
import com.gm.entity.Member;
import com.gm.entity.MembershipPlan;
import com.gm.entity.Payment;
import com.gm.exception.MemberNotFoundException;
import com.gm.exception.MembershipPlanNotFoundException;
import com.gm.mapper.PaymentMapper;
import com.gm.repository.MemberRepository;
import com.gm.repository.MembershipPlanRepository;
import com.gm.repository.PaymentRepository;

//@Service
//public class PaymentService {
//
//	@Autowired
//	private PaymentRepository paymentRepo;
//
//	@Autowired
//	private MembershipPlanRepository planRepo;
//
//	public PaymentResponse purchaseMembership(Long planId, Long memberId) {
//
//		MembershipPlan plan = planRepo.findById(planId).orElseThrow(
//				() -> new MembershipPlanNotFoundException("Plan with id : "+planId+"not found")
//				);
//
//		// Create payment (PENDING)
//		Payment payment = new Payment();
//		payment.setMemberId(memberId);
//		payment.setMembershipPlanId(planId);
//		payment.setAmount(plan.getPrice());
//		payment.setStatus(PaymentStatus.PENDING);
//
//		paymentRepo.save(payment);
//
//		// Simulate successful payment
//		payment.setStatus(PaymentStatus.PAID);
//		payment.setPaymentDate(LocalDateTime.now());
//
//		paymentRepo.save(payment);
//
//		return new PaymentResponse(
//				payment.getId(), 
//				payment.getMemberId(),
//				payment.getMembershipPlanId(),
//				payment.getAmount(), 
//				payment.getStatus(),
//				payment.getPaymentDate()
//				);
//	}
//
//}

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MembershipPlanRepository membershipRepository;
    
    @Autowired
    private PaymentMapper mapper;

    public PaymentResponse makePayment(PurchaseMembershipRequest request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException("Customer not found"));

        MembershipPlan membership = membershipRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MembershipPlanNotFoundException("Membership not found"));

        Payment payment = PaymentMapper.toEntity(
                member,
                membership,
                request.getAmount()
        );

        Payment saved = paymentRepository.save(payment);

        return PaymentMapper.toResponse(saved);
    }

    @Override
    public List<PaymentResponse> getPaymentsByCustomer(Long customerId) {

        List<Payment> payments = paymentRepository.findByCustomerId(customerId);
        List<PaymentResponse> responses = new ArrayList<>();

        for (Payment payment : payments) {
            responses.add(PaymentMapper.toResponse(payment));
        }

        return responses;
    }
}

