package com.gm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.config.CurrentUserUtil;
import com.gm.dto.request.CancelEquipmentBookingRequest;
import com.gm.dto.request.CreateEquipmentBookingRequest;
import com.gm.dto.request.CreateMemberRequest;
import com.gm.dto.request.CreateRatingRequest;
import com.gm.dto.request.PurchaseMembershipRequest;
import com.gm.dto.request.UpdateMemberRequest;
import com.gm.dto.response.DietPlanResponse;
import com.gm.dto.response.EquipmentBookingResponse;
import com.gm.dto.response.MemberResponse;
import com.gm.dto.response.MembershipPlanResponse;
import com.gm.dto.response.PaymentResponse;
import com.gm.dto.response.RatingResponse;
import com.gm.entity.User;
import com.gm.service.DietPlanService;
import com.gm.service.EquipmentBookingService;
import com.gm.service.MemberService;
import com.gm.service.MembershipPlanService;
import com.gm.service.PaymentService;
import com.gm.service.RatingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private CurrentUserUtil currentUserUtil;

	@Autowired
	private MemberService service;

	@Autowired
	private MemberService memberService;

	@Autowired
	private DietPlanService dietPlanService;

	@Autowired
	private MembershipPlanService membershipPlanService;

	@Autowired
	private EquipmentBookingService bookingService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private RatingService ratingService;

	@GetMapping("/home")
	public String home() {
		User user = currentUserUtil.getUser();
		return "Welcome " + user.getUsername();
	}

	@PostMapping("/add")
	public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody CreateMemberRequest request) {
		MemberResponse response = service.createMember(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/profile")
	public ResponseEntity<MemberResponse> getMyProfile() {
		User user = currentUserUtil.getUser();
		return ResponseEntity.ok(service.getMyProfile(user));
	}

	@PutMapping("/profile")
	public MemberResponse updateProfile(@Valid @RequestBody UpdateMemberRequest request) {
		return memberService.updateProfile(request);
	}

	// MEMBERSHIP

	@GetMapping("/membership")
	public List<MembershipPlanResponse> getActiveMemberships() {
		return membershipPlanService.getActiveMemberships();
	}

	// EQUIPMENTBOOKING

	@PostMapping("/equipment-booking")
	public EquipmentBookingResponse bookEquipment(@Valid @RequestBody CreateEquipmentBookingRequest request) {
		return bookingService.bookEquipment(request);
	}

	@GetMapping("/equipment-bookings/{memberId}")
	public List<EquipmentBookingResponse> getMyBookings(@PathVariable Long id) {
		return bookingService.getBookingsByMember(id);
	}

	@DeleteMapping("/equipment-booking")
	public String cancelBooking(@RequestBody CancelEquipmentBookingRequest request) {

		bookingService.cancelBooking(request);
		return "Equipment booking cancelled successfully";
	}

	// PAYMENT

	@PostMapping("/payment")
	public PaymentResponse makePayment(@RequestBody PurchaseMembershipRequest request) {

		return paymentService.makePayment(request);
	}

	@GetMapping("/payments/{memberId}")
	public List<PaymentResponse> getMyPayments(@PathVariable Long id) {

		return paymentService.getPaymentsByCustomer(id);
	}

	// RATING

	@PostMapping("/rating")
	public RatingResponse addRating(@Valid @RequestBody CreateRatingRequest request) {
		return ratingService.addRating(request);
	}

	@GetMapping("/ratings/{memberId}")
	public List<RatingResponse> getMyRatings(@PathVariable Long id) {
		return ratingService.getRatingsByMember(id);
	}

	// DIET PLAN

	@GetMapping("/diet-plan/{customerId}")
	public DietPlanResponse getActiveDietPlan(@PathVariable Long memberId) {
		return dietPlanService.getActiveDietPlanForCustomer(memberId);
	}

}
