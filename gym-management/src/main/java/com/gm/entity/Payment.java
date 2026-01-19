package com.gm.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.gm.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private MembershipPlan membership;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime paymentDate;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, Member member, MembershipPlan membership, Double amount, PaymentStatus status,
			LocalDateTime paymentDate) {
		super();
		this.id = id;
		this.member = member;
		this.membership = membership;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public MembershipPlan getMembership() {
		return membership;
	}

	public void setMembership(MembershipPlan membership) {
		this.membership = membership;
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