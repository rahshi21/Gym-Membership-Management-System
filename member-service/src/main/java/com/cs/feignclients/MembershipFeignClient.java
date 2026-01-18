package com.cs.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.dto.response.MembershipPlanResponse;

@FeignClient(name="membership-service", path="/api/memberships")	
public interface MembershipFeignClient {

	@GetMapping("/{id}")
	public ResponseEntity<MembershipPlanResponse> getPlan(@PathVariable Long id);
}