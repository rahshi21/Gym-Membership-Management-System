package com.gm.dto.request;

import jakarta.validation.constraints.NotNull;

public class CancelEquipmentBookingRequest {
	
	@NotNull(message = "Booking Id is mandatory")
	private Long bookingId;

	public CancelEquipmentBookingRequest() {
		super();
	}

	public CancelEquipmentBookingRequest(@NotNull(message = "Booking Id is mandatory") Long bookingId) {
		super();
		this.bookingId = bookingId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	
	

}
