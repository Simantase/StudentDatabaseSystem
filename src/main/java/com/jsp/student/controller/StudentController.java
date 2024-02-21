package com.jsp.student.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.student.model.Student;
import com.jsp.student.service.StudentService;
import com.jsp.student.utility.ResponseStructure;
@RestController
public class StudentController {
	@Autowired
	private StudentService studentservice;
	@PostMapping(value ="/add")//WebService or SomeTime Developer call as Api.As I use @RestController & 
	//@PostMapping(value ="/add") so it is called as RestFull Api.
	public ResponseEntity<ResponseStructure<Student>> add(@RequestBody Student s)
	{
		return studentservice.add(s);
	}
	@PostMapping(value = "/addAll")
	public ResponseEntity<ResponseStructure<List<Student>>> addAll(@RequestBody List<Student> l1)
	{
		ResponseEntity<ResponseStructure<List<Student>>> l2 = studentservice.addAll(l1);
		return l2;
	}
	@PostMapping(value = "/findById/{studentId}")
	public ResponseEntity<ResponseStructure<Student>> findById(@PathVariable int studentId)
	{
		return studentservice.findById(studentId);
	}
	@PostMapping(value = "/findByName/{studentName}")
	public ResponseEntity<ResponseStructure<Student>> findByStudentName(@PathVariable String studentName)
	{
		return studentservice.findByName(studentName);
	}
	@PostMapping(value = "/findByMarks/{studentMarks}")
	public ResponseEntity<ResponseStructure<Student>> findByMarks(@PathVariable int studentMarks)
	{
		return studentservice.findByMarks(studentMarks);
	}
	@PostMapping(value = "/findAll")
	public ResponseEntity<ResponseStructure<List<Student>>> findAll()
	{
		return studentservice.findAll();
	}
	@PutMapping(value = "/update/{studentId}")
	public ResponseEntity<ResponseStructure<Student>> update(@PathVariable int studentId,@RequestBody Student updatedStudent)
	{
		return studentservice.update(studentId, updatedStudent);
	}
	@DeleteMapping(value = "/deleteById/{studentId}")
	public ResponseEntity<ResponseStructure<Student>> deleteById(@PathVariable int studentId)
	{
		return studentservice.deleteById(studentId);
	}
}
