package com.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.dto.response.MemberResponse;
import com.cs.service.MemberService;


@RestController
@RequestMapping("/api/admin/member")
public class AdminController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<MemberResponse> getMember(@PathVariable Long id){
		return ResponseEntity.ok(service.getMemberById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<MemberResponse>> getAllMembers(){
		return ResponseEntity.ok(service.getAllMembers());
	}

}
