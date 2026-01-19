package com.gm.mapper;

import com.gm.dto.request.CreateTrainerRequest;
import com.gm.dto.response.TrainerResponse;
import com.gm.entity.Trainer;

public class TrainerMapper {

    public Trainer toEntity(CreateTrainerRequest request) {

        Trainer trainer = new Trainer();
        trainer.setFirstName(request.getFirstName());
        trainer.setLastName(request.getLastName());
        trainer.setEmail(request.getEmail());
        trainer.setPhone(request.getPhone());
        trainer.setExperience(request.getExperience());
        trainer.setExpertise(request.getExpertise());
        trainer.setAvailability(request.getAvailability());

        return trainer;
    }

    public TrainerResponse toResponse(Trainer trainer) {

        TrainerResponse response = new TrainerResponse();
        response.setId(trainer.getId());
        response.setFirstName(trainer.getFirstName());
        response.setLastName(trainer.getLastName());
        response.setEmail(trainer.getEmail());
        response.setPhone(trainer.getPhone());
        response.setExperience(trainer.getExperience());
        response.setExpertise(trainer.getExpertise());
        response.setAvailability(trainer.getAvailability());

        return response;
    }
}
