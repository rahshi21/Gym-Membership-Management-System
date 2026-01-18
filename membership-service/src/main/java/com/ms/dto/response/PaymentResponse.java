package com.ms.dto.response;

import java.time.LocalDateTime;

import com.ms.enums.PaymentStatus;

public class PaymentResponse {

	private Long id;
	private Long customerId;
	private Long membershipPlanId;
	private Double amount;
	private PaymentStatus status;
	private LocalDateTime paymentDate;

	public PaymentResponse() {
		super();
	}

	public PaymentResponse(Long id, Long customerId, Long membershipPlanId, Double amount, PaymentStatus status,
			LocalDateTime paymentDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.membershipPlanId = membershipPlanId;
		this.amount = amount;
		this.status = status;
		this.paymentDate = paymentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getMembershipPlanId() {
		return membershipPlanId;
	}

	public void setMembershipPlanId(Long membershipPlanId) {
		this.membershipPlanId = membershipPlanId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

}
