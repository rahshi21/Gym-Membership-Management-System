package com.ms.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.ms.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long customerId;

	private Long membershipPlanId;

	private Double amount;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime paymentDate;

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

	public Payment() {
		super();
	}

	public Payment(Long id, Long customerId, Long membershipPlanId, Double amount, PaymentStatus status,
			LocalDateTime paymentDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.membershipPlanId = membershipPlanId;
		this.amount = amount;
		this.status = status;
		this.paymentDate = paymentDate;
	}

}