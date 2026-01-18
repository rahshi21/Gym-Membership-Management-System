package com.cs.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.dto.response.DietPlanResponse;

@FeignClient(name="trainer-service", path="/api/diet-plans")	
public interface DietPlanFeignClient {

	@GetMapping("/{id}")
	public ResponseEntity<DietPlanResponse> getDietPlan(@PathVariable Long id);
}