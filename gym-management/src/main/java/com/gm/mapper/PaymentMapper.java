package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.response.PaymentResponse;
import com.gm.entity.Member;
import com.gm.entity.MembershipPlan;
import com.gm.entity.Payment;
import com.gm.enums.PaymentStatus;

@Component
public class PaymentMapper {

    public Payment toEntity(
            Member member,
            MembershipPlan membership,
            Double amount) {

        Payment payment = new Payment();
        payment.setMember(member);
        payment.setMembership(membership);
        payment.setAmount(amount);
        payment.setStatus(PaymentStatus.PAID);
        payment.setPaymentDate(LocalDateTime.now());

        return payment;
    }

    public PaymentResponse toResponse(Payment payment) {

        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setMemberId(payment.getMember().getId());
        response.setMembershipPlanId(payment.getMembership().getId());
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus());
        response.setPaymentDate(payment.getPaymentDate());

        return response;
    }
}
