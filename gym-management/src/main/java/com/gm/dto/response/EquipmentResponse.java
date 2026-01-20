package com.gm.dto.response;

import java.time.LocalDateTime;

import com.gm.enums.EquipmentStatus;

public class EquipmentResponse {
	
	private Long id;
    private String equipmentName;
    private Integer totalQuantity;
    private Integer availableQuantity;
    private EquipmentStatus status;
   	private LocalDateTime createdAt;
   	private LocalDateTime updatedAt;
   	
	public EquipmentResponse() {
		super();
	}

	public EquipmentResponse(Long id, String equipmentName, Integer totalQuantity, Integer availableQuantity,
			EquipmentStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.equipmentName = equipmentName;
		this.totalQuantity = totalQuantity;
		this.availableQuantity = availableQuantity;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public EquipmentStatus getStatus() {
		return status;
	}

	public void setStatus(EquipmentStatus status) {
		this.status = status;
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
