package com.gm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gm.dto.request.AddEquipmentStockRequest;
import com.gm.dto.request.CreateEquipmentRequest;
import com.gm.dto.request.UpdateEquipmentStatusRequest;
import com.gm.dto.response.EquipmentResponse;
import com.gm.entity.Equipment;
import com.gm.enums.EquipmentStatus;
import com.gm.exception.EquipmentNotFoundException;
import com.gm.mapper.EquipmentMapper;
import com.gm.repository.EquipmentRepository;

@Service
public class EquipmentService {

    Logger logger = LoggerFactory.getLogger(EquipmentService.class);

    @Autowired
    private EquipmentRepository equipmentRepository;
    
    @Autowired
    private EquipmentMapper mapper;

    public ResponseEntity<?> createEquipment(CreateEquipmentRequest request) {

        Equipment equipment = mapper.toEquipment(request);
        equipmentRepository.save(equipment);

        logger.info("Equipment created successfully");

        return ResponseEntity.ok("Equipment added successfully");
    }

    public ResponseEntity<?> addEquipmentStock(AddEquipmentStockRequest request) {

        Equipment equipment = equipmentRepository
        		.findById(request.getEquipmentId())
                .orElseThrow(
                		() -> new EquipmentNotFoundException("Equipment not found")
                		);

        equipment.setTotalQuantity(equipment.getTotalQuantity() + request.getQuantity());
        equipment.setAvailableQuantity(equipment.getAvailableQuantity() + request.getQuantity());
        equipment.setUpdatedAt(LocalDateTime.now());

        equipmentRepository.save(equipment);

        return ResponseEntity.ok("Equipment stock updated successfully");
    }

    public ResponseEntity<?> updateEquipmentStatus(UpdateEquipmentStatusRequest request) {

        Equipment equipment = equipmentRepository.findById(request.getEquipmentId())
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found"));

        equipment.setStatus(request.getStatus());
        equipment.setUpdatedAt(LocalDateTime.now());

        equipmentRepository.save(equipment);

        return ResponseEntity.ok("Equipment status updated successfully");
    }
    
    public List<EquipmentResponse> findByStatus(EquipmentStatus status) {

        List<Equipment> equipmentList = equipmentRepository.findByStatus(status);
        
        if(equipmentList.isEmpty())	{
        	throw new EquipmentNotFoundException(
        			"No equipment found with status : " + status
        			);
        }

        List<EquipmentResponse> responseList = new ArrayList<>();
        
        for(Equipment equipment : equipmentList) {
        	responseList.add(mapper.toResponse(equipment));
        }
        
        return responseList;
    }

    public ResponseEntity<?> getAllEquipment() {

        List<Equipment> equipmentList = equipmentRepository.findAll();
        return ResponseEntity.ok(equipmentList);
    }
}
