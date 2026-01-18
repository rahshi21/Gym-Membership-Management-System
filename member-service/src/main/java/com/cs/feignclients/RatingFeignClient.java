package com.cs.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.dto.response.RatingResponse;

@FeignClient(name="rating-service", path="/api/ratings")	
public interface RatingFeignClient {

	@GetMapping("/{id}")
	public ResponseEntity<RatingResponse> getRating(@PathVariable Long id);
}