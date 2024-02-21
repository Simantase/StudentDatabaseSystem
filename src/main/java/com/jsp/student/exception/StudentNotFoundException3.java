package com.jsp.student.exception;

public class StudentNotFoundException3 extends RuntimeException {
	private String message;

	public StudentNotFoundException3(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
