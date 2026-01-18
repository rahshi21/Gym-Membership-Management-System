package com.cs.mapper;

import org.springframework.stereotype.Component;

import com.cs.dto.request.CreateMemberRequest;
import com.cs.dto.response. MemberResponse;
import com.cs.entity.Member;

@Component
public class MemberMapper {
	
	public Member toEntity(CreateMemberRequest req) {
		Member member = new Member();
		member.setUsername(req.getUsername());
		member.setFirstName(req.getFirstName());
		member.setLastName(req.getLastName());
		member.setEmail(req.getEmail());
		member.setPhone(req.getPhone());
		member.setDateOfBirth(req.getDateOfBirth());
		member.setAddress(req.getAddress());
//		member.setCreatedAt(LocalDateTime.now());
//		member.setUpdatedAt(LocalDateTime.now());
		member.setPlanId(req.getPlanId());
		
		return member;
	}
	
	public MemberResponse toResponse(Member member) {
		return new MemberResponse(
					member.getId(),
					member.getUsername(),
					member.getFirstName(),
					member.getLastName(),
					member.getEmail(),
					member.getPhone(),
					member.getDateOfBirth(),
					member.getAddress(),
					member.getCreatedAt(),
					member.getUpdatedAt(), null, null, null, null, null
				);
	}

}
