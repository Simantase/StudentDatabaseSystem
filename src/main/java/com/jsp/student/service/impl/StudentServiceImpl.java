package com.jsp.student.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.student.exception.StudentNotFoundException;
import com.jsp.student.exception.StudentNotFoundException1;
import com.jsp.student.exception.StudentNotFoundException2;
import com.jsp.student.exception.StudentNotFoundException3;
import com.jsp.student.model.Student;
import com.jsp.student.repository.StudentRepository;
import com.jsp.student.service.StudentService;
import com.jsp.student.utility.ResponseStructure;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public ResponseEntity<ResponseStructure<Student>> add(Student s) {
		Student s1=studentrepository.save(s);
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setStatusMessage("Data Is Saved Successfully");
		responseStructure.setData(s);
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<ResponseStructure<List<Student>>> addAll(List<Student> l1) {
		List<Student> l=studentrepository.saveAll(l1);
		ResponseStructure<List<Student>> responseStructure=new ResponseStructure<List<Student>>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setStatusMessage("All The Data Are Saved Successfully");
		responseStructure.setData(l);
		return new ResponseEntity<ResponseStructure<List<Student>>>(responseStructure,HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<ResponseStructure<Student>> findById(int studentId) {
		Optional<Student> o1 = studentrepository.findById(studentId);
		if(o1.isPresent())
		{
			ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setStatusMessage("Data Is Fetched Successfully");
			responseStructure.setData(o1.get());
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new StudentNotFoundException("Student With Given Id Is Not Found!!");
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<Student>> findByName(String studentName) {
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setStatusMessage("Data Is Fetched Successfully");
		responseStructure.setData(studentrepository.findByStudentName(studentName));
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
	}
	@Override
	public ResponseEntity<ResponseStructure<Student>> findByMarks(int studentMarks) {
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setStatusMessage("Data Is Fetched Successfully");
		responseStructure.setData(studentrepository.findByStudentMarks(studentMarks));
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
	}
	@Override
	public ResponseEntity<ResponseStructure<List<Student>>> findAll() {
		List<Student> findAll = studentrepository.findAll();
		if(!(findAll.isEmpty()))
		{
			ResponseStructure<List<Student>> responseStructure=new ResponseStructure<List<Student>>();
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setStatusMessage("All The Data Are Fetched Successfully");
			responseStructure.setData(studentrepository.findAll());
			return new ResponseEntity<ResponseStructure<List<Student>>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new StudentNotFoundException1("Student's Data Is Not Found!!!");
		}

	}
	@Override
	public ResponseEntity<ResponseStructure<Student>> update(int studentId,Student updatedStudent) {
		Optional<Student> o2 = studentrepository.findById(studentId);
		if(o2.isPresent())
		{
			Student exixtingStudent=o2.get();
			updatedStudent.setStudentId(exixtingStudent.getStudentId());
			ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setStatusMessage("Data Is Updated Successfully");
			responseStructure.setData(studentrepository.save(updatedStudent));
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new StudentNotFoundException2("Student Data Is Not Updated!!!");
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<Student>> deleteById(int studentId) {
		Optional<Student> o3 = studentrepository.findById(studentId);
		if(o3.isPresent())
		{
			Student exixtingStudent=o3.get();
			studentrepository.deleteById(studentId);
			ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setStatusMessage("Data Is Deleted Successfully");
			responseStructure.setData(exixtingStudent);
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		}
		throw new StudentNotFoundException3("Student Data Is Not Deleted!!!");
	}
}
