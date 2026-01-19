package com.gm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gm.dto.request.CreateTrainerRequest;
import com.gm.dto.request.UpdateTrainerRequest;
import com.gm.dto.response.TrainerResponse;
import com.gm.entity.Trainer;
import com.gm.exception.MemberNotFoundException;
import com.gm.exception.TrainerNotFoundException;
import com.gm.mapper.TrainerMapper;
import com.gm.repository.TrainerRepository;

@Service
public class TrainerService{

	Logger logger = LoggerFactory.getLogger(TrainerService.class);
	
	@Autowired
    private TrainerRepository trainerRepo;
	
	@Autowired
	private TrainerMapper mapper;

    public TrainerResponse addTrainer(CreateTrainerRequest request) {
        Trainer trainer = mapper.toEntity(request);
        Trainer saved = trainerRepo.save(trainer);
        TrainerResponse response = mapper.toResponse(saved);

        return response;
    }

    public TrainerResponse updateTrainer(UpdateTrainerRequest request) {
    	Trainer trainer = trainerRepo.findById(request.getId()).orElseThrow(
				() -> new MemberNotFoundException("This member id does not exist"));

    	trainer.setEmail(request.getEmail());
    	trainer.setPhone(request.getPhone());
    	trainer.setAvailability(request.getAvailability());
		

		Trainer saved = trainerRepo.save(trainer);
		logger.info(saved.toString());
		TrainerResponse response = mapper.toResponse(saved);

		return response;
	}
    
    public ResponseEntity<?> getAssignedCustomers(Long id) {
        Trainer trainer = trainerRepo.findById(id)
                .orElseThrow(() -> new TrainerNotFoundException("Trainer id : " + id + " not found"));

        return ResponseEntity.ok(trainer.getAssignedMembers());
    }
    
    public TrainerResponse getTrainerById(Long id) {
    	logger.info("Get Trainer by id : " + id);
        Trainer trainer = trainerRepo.findById(id)
                .orElseThrow(() -> new TrainerNotFoundException("Trainer id : " + id + " not found"));

        TrainerResponse response = mapper.toResponse(trainer);
		return response;
    }
    
    public List<TrainerResponse> getAllTrainers() {
    	return trainerRepo.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
    }
}
