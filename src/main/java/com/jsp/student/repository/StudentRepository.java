package com.jsp.student.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.student.model.Student;
public interface StudentRepository extends JpaRepository<Student,Integer>{
	public Student findByStudentName(String studentName);
	public Student findByStudentMarks(int studentMarks);
}
