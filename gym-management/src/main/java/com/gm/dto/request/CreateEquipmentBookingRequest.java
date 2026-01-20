package com.gm.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEquipmentBookingRequest {

	@NotNull(message = "Member Id is mandatory")
	private Long memberId;

	@NotNull(message = "Equipment Id is mandatory")
	private Long equipmentId;

//	@NotBlank(message = "booking date is mandatory")
	@Future
	private LocalDate bookingDate;

	@NotBlank(message = "time slot is mandatory")
	private String timeslot;

	public CreateEquipmentBookingRequest() {
		super();
	}

	public CreateEquipmentBookingRequest(Long memberId, Long equipmentId, LocalDate bookingDate, String timeslot) {
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

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}
	
}
