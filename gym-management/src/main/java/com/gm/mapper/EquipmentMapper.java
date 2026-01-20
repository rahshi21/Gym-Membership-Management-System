package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.request.CreateEquipmentRequest;
import com.gm.dto.response.EquipmentResponse;
import com.gm.entity.Equipment;
import com.gm.enums.EquipmentStatus;

@Component
public class EquipmentMapper {

    public Equipment toEquipment(CreateEquipmentRequest request) {

        Equipment equipment = new Equipment();
        equipment.setEquipmentName(request.getEquipmentName());
        equipment.setTotalQuantity(request.getTotalQuantity());
        equipment.setAvailableQuantity(request.getTotalQuantity());
        equipment.setStatus(EquipmentStatus.WORKING);
        equipment.setCreatedAt(LocalDateTime.now());

        return equipment;
    }

	public EquipmentResponse toResponse(Equipment equipment) {
		EquipmentResponse response = new EquipmentResponse();
		response.setId(equipment.getId());
		response.setEquipmentName(equipment.getEquipmentName());
		response.setTotalQuantity(equipment.getTotalQuantity());
		response.setAvailableQuantity(equipment.getAvailableQuantity());
		return response;
	}
}