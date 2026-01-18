package com.cs.dto.response;

public class MembershipPlanResponse {
	
	private Long Id;
	
	private String membershipLevel;
	private String goal;
	private Double price;
	private Integer durationInMonths;
	
	public MembershipPlanResponse() {
		super();
	}

	public MembershipPlanResponse(Long id, String membershipLevel, String goal, Double price,
			Integer durationInMonths) {
		super();
		Id = id;
		this.membershipLevel = membershipLevel;
		this.goal = goal;
		this.price = price;
		this.durationInMonths = durationInMonths;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMembershipLevel() {
		return membershipLevel;
	}

	public void setMembershipLevel(String membershipLevel) {
		this.membershipLevel = membershipLevel;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(Integer durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	

}
