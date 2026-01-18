package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.request.CreateMembershipPlanRequest;
import com.ms.dto.response.MembershipPlanResponse;
import com.ms.service.MembershipPlanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/memberships")
public class MembershipPlanController {
	
	@Autowired
	private MembershipPlanService service;
	
	@PostMapping
	public ResponseEntity<MembershipPlanResponse> createPlan(@Valid @RequestBody CreateMembershipPlanRequest request){
		MembershipPlanResponse response = service.createPlan(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MembershipPlanResponse> getPlan(@PathVariable Long id){
		return ResponseEntity.ok(service.getPlanById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<MembershipPlanResponse>> getAllPlans(){
		return ResponseEntity.ok(service.getAllPlans());
	}
}
