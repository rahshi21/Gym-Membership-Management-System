package com.ms.exception;

public class MembershipPlanNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	// default constructor
	public MembershipPlanNotFoundException() {
		super();
	}
	
	public MembershipPlanNotFoundException(String message) {
		super(message);
	}
}
