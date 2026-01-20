package com.gm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.gm.dto.request.CreateMemberRequest;
import com.gm.dto.request.UpdateMemberRequest;
import com.gm.dto.response.MemberResponse;
import com.gm.entity.Member;
import com.gm.entity.User;
import com.gm.exception.MemberNotFoundException;
import com.gm.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceTest {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@BeforeEach
	void setup() {
		memberRepository.deleteAll();
	}

	@Test
	void testCreateMember_success() {
		CreateMemberRequest request = new CreateMemberRequest();
		request.setUsername("rahshitha");
		request.setEmail("rah@gmail.com");
		request.setPhone("9999999999");
		request.setAddress("Coimbatore");

		MemberResponse response = memberService.createMember(request);

		assertNotNull(response);
		assertEquals("rahshitha", response.getUsername());
		assertEquals("rah@gmail.com", response.getEmail());
	}

	@Test
	void testUpdateProfile_success() {
		Member member = new Member();
		member.setUsername("MEMBER");
		member.setEmail("old@gmail.com");
		member.setPhone("1111111111");
		member.setAddress("Old Address");

		Member saved = memberRepository.save(member);

		UpdateMemberRequest request = new UpdateMemberRequest();
		request.setId(saved.getId());
		request.setEmail("new@gmail.com");
		request.setPhone("2222222222");
		request.setAddress("New Address");

		MemberResponse response = memberService.updateProfile(request);

		assertEquals("new@gmail.com", response.getEmail());
		assertEquals("2222222222", response.getPhone());
		assertEquals("New Address", response.getAddress());
	}

	@Test
	void testUpdateProfile_memberNotFound() {
		UpdateMemberRequest request = new UpdateMemberRequest();
		request.setId(999L);

		assertThrows(MemberNotFoundException.class,
				() -> memberService.updateProfile(request));
	}

	@Test
	void testGetMyProfile_success() {
		Member member = new Member();
		member.setUsername("rahshitha");
		member.setEmail("rah@gmail.com");

		memberRepository.save(member);

		User user = new User();
		user.setUsername("rahshitha");

		MemberResponse response = memberService.getMyProfile(user);

		assertEquals("rahshitha", response.getUsername());
		assertEquals("rah@gmail.com", response.getEmail());
	}

	@Test
	void testGetMyProfile_notFound() {
		User user = new User();
		user.setUsername("unknown");

		assertThrows(MemberNotFoundException.class,
				() -> memberService.getMyProfile(user));
	}

	@Test
	void testGetMemberById_success() {
		Member member = new Member();
		member.setUsername("member2");

		Member saved = memberRepository.save(member);

		MemberResponse response = memberService.getMemberById(saved.getId());

		assertEquals("member2", response.getUsername());
	}

	@Test
	void testGetAllMembers_success() {
		Member m1 = new Member();
		m1.setUsername("member1");

		Member m2 = new Member();
		m2.setUsername("member2");

		memberRepository.save(m1);
		memberRepository.save(m2);

		List<MemberResponse> members = memberService.getAllMembers();

		assertEquals(2, members.size());
	}
}
