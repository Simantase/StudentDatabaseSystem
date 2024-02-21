package com.jsp.student.utility;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.student.exception.StudentNotFoundException;
import com.jsp.student.exception.StudentNotFoundException1;
import com.jsp.student.exception.StudentNotFoundException2;
import com.jsp.student.exception.StudentNotFoundException3;

@RestControllerAdvice
public class ApplicationHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> studentNotFoundById(StudentNotFoundException ex)
	{
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Student Object With Given Id Is Not Present!!!");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> studentnotFoundAll(StudentNotFoundException1 ex1)
	{
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex1.getMessage());
		errorStructure.setErrorData("Student Data Is Not Present In Database");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> studentNotFoundForUpdate(StudentNotFoundException2 ex2)
	{
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex2.getMessage());
		errorStructure.setErrorData("Student Data Is Not Updated!!");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> deleteStudentById(StudentNotFoundException3 ex3)
	{
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex3.getMessage());
		errorStructure.setErrorData("Student Data Is Not Deleted!!!");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
}
