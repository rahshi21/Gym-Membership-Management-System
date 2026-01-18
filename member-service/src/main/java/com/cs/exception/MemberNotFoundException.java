package com.cs.exception;

public class MemberNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	// default constructor
	public MemberNotFoundException() {
		super();
	}
	
	public MemberNotFoundException(String message) {
		super(message);
	}
}
