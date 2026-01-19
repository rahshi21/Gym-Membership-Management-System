package com.gm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.dto.request.CreateDietPlanRequest;
import com.gm.dto.request.CreateTrainerRequest;
import com.gm.dto.request.UpdateDietPlanRequest;
import com.gm.dto.request.UpdateTrainerRequest;
import com.gm.dto.response.DietPlanResponse;
import com.gm.dto.response.RatingResponse;
import com.gm.dto.response.TrainerResponse;
import com.gm.service.DietPlanService;
import com.gm.service.RatingService;
import com.gm.service.TrainerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private DietPlanService dietPlanService;
    
    @Autowired
	private RatingService ratingService;

    //PROFILE
    
    @PostMapping("/profile")
	public TrainerResponse addTrainer(@Valid @RequestBody CreateTrainerRequest request) {
		return trainerService.addTrainer(request);
	}

	@PutMapping("/profile")
	public TrainerResponse updateTrainer(@Valid @RequestBody UpdateTrainerRequest request) {
		return trainerService.updateTrainer(request);
	}

    @GetMapping("/profile/{id}")
    public TrainerResponse getTrainerProfile(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }

    //CUSTOMERS

    @GetMapping("/customers/{trainerId}")
    public ResponseEntity<?> getAssignedCustomers(@PathVariable Long trainerId) {
        return trainerService.getAssignedCustomers(trainerId);
    }

    //DIET PLAN

    @PostMapping("/diet-plan")
    public DietPlanResponse createDietPlan(@Valid @RequestBody CreateDietPlanRequest request) {
        return dietPlanService.createDietPlan(request);
    }

    @PutMapping("/diet-plan")
    public DietPlanResponse updateDietPlanContent(@Valid @RequestBody UpdateDietPlanRequest request) {
        return dietPlanService.updateDietPlanContent(request);
    }
    
    @GetMapping("/diet-plans/{trainerId}")
    public List<DietPlanResponse> getDietPlans(@PathVariable Long trainerId) {
        return dietPlanService.getDietPlansByTrainer(trainerId);
    }

    // RATING
    
    @GetMapping("/ratings/{trainerId}")
    public List<RatingResponse> getTrainerRatings(@PathVariable Long trainerId) {
        return ratingService.getRatingsByTrainer(trainerId);
    }

}
