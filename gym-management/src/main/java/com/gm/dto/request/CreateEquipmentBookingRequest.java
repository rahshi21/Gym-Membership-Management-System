package com.gm.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEquipmentBookingRequest {

	@NotNull(message = "Member Id is mandatory")
	private Long memberId;

	@NotNull(message = "Equipment Id is mandatory")
	private Long equipmentId;

	@NotBlank(message = "booking date in Diet is mandatory")
	private LocalDateTime bookingDate;

	@NotBlank(message = "time slot is mandatory")
	private String timeslot;

	public CreateEquipmentBookingRequest() {
		super();
	}

	public CreateEquipmentBookingRequest(Long memberId, Long equipmentId, LocalDateTime bookingDate, String timeslot) {
		super();
		this.memberId = memberId;
		this.equipmentId = equipmentId;
		this.bookingDate = bookingDate;
		this.timeslot = timeslot;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}
	
}
