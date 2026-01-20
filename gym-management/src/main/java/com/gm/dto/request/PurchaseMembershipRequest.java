package com.gm.dto.request;

import jakarta.validation.constraints.NotNull;

public class PurchaseMembershipRequest {
	
	@NotNull(message = "Member ID is required")
	private Long memberId;
	
	@NotNull
    private Long membershipId;

    @NotNull
    private Double amount;


	public PurchaseMembershipRequest() {
		super();
	}


	public PurchaseMembershipRequest(@NotNull(message = "Member ID is required") Long memberId,
			@NotNull Long membershipId, @NotNull Double amount) {
		super();
		this.memberId = memberId;
		this.membershipId = membershipId;
		this.amount = amount;
	}


	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public Long getMembershipId() {
		return membershipId;
	}


	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	
	
	

}
