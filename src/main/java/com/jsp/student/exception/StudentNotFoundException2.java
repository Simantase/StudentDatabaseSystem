package com.jsp.student.exception;

public class StudentNotFoundException2 extends RuntimeException {
	private String message;

	public StudentNotFoundException2(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
