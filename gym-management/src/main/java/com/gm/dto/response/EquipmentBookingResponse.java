package com.gm.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EquipmentBookingResponse {

	private Long bookingId;
	private Long memberId;
	private Long equipmentId;
	private String equipmentName;
	private LocalDate bookingDate;
	private String timeslot;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public EquipmentBookingResponse() {
		super();
	}

	public EquipmentBookingResponse(Long bookingId, Long memberId, Long equipmentId, String equipmentName,
			LocalDate bookingDate, String timeslot, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.bookingId = bookingId;
		this.memberId = memberId;
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.bookingDate = bookingDate;
		this.timeslot = timeslot;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
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

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	

	
}
