package com.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.dto.request.CreateMemberRequest;
import com.cs.dto.response.MemberResponse;
import com.cs.entity.User;
import com.cs.service.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private User user;
	
	@PostMapping
	public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody CreateMemberRequest request){
		MemberResponse response = service.createMember(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/profile")
	public ResponseEntity<MemberResponse> getMyProfile(){
		return ResponseEntity.ok(service.getMyProfile(user));
	}
	

}
