package com.cs.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.dto.response.TrainerResponse;

@FeignClient(name="trainer-service", path="/api/trainers")	
public interface TrainerFeignClient {

	@GetMapping("/{id}")
	public ResponseEntity<TrainerResponse> getTrainer(@PathVariable Long id);
}