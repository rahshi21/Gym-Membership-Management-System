package com.ms.dto.request;

import jakarta.validation.constraints.NotNull;

public class PurchaseMembershipRequest {
	
	@NotNull(message = "Customer ID is required")
	private Long customerId;

	public PurchaseMembershipRequest() {
		super();
	}

	public PurchaseMembershipRequest(@NotNull(message = "Customer ID is required") Long customerId) {
		super();
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	

}
