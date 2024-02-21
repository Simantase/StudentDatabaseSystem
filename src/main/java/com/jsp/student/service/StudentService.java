package com.jsp.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.student.model.Student;
import com.jsp.student.utility.ResponseStructure;

public interface StudentService {
	public ResponseEntity<ResponseStructure<Student>> add(Student s);
	public ResponseEntity<ResponseStructure<List<Student>>> addAll(List<Student> l1);
	public ResponseEntity<ResponseStructure<Student>> findById(int studentId);
	public ResponseEntity<ResponseStructure<Student>> findByName(String studentName);
	public ResponseEntity<ResponseStructure<Student>> findByMarks(int studentMarks);
	public ResponseEntity<ResponseStructure<List<Student>>> findAll();
	public ResponseEntity<ResponseStructure<Student>> update(int studentId,Student updatedStudent);
	public ResponseEntity<ResponseStructure<Student>> deleteById(int studentId);
}
