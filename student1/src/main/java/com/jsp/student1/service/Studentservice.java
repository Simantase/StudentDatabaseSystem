package com.jsp.student1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.student1.entity.Student;
import com.jsp.student1.repository.Studentrepository;

@Service
public class Studentservice {
	@Autowired
	private Studentrepository sr;
	public void insert1(int sId,String sName,int sMarks)
	{
		sr.insert2(sId, sName, sMarks);
	}
	public void update1(int sId,int sMarks)
	{
		sr.update2(sId,sMarks);
	}
	public void delete1(int sId)
	{
		sr.delete2(sId);
	}
	public List<Student> fetch1()
	{
		List<Student> l1=sr.fetch2();
		return l1;
	}
}
