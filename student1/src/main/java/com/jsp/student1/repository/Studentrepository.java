package com.jsp.student1.repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.student1.entity.Student;

@Repository
public class Studentrepository {
	public void insert2(int sId,String sName,int sMarks)
	{
		Student s=new Student();
		s.setsId(sId);
		s.setsName(sName);
		s.setsMarks(sMarks);

		Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		// Business Logic
		session.save(s);

		trans.commit();
		session.close();


	}
	public void update2(int sId,int sMarks)
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		// Business Logic
		Student s=session.find(Student.class,sId);
		s.setsMarks(sMarks);
		session.update(s);

		trans.commit();
		session.close();
	}
	public void delete2(int sId)
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		// Business Logic
		Student s=session.find(Student.class,sId);
		session.delete(s);

		trans.commit();
		session.close();
	}
	public List<Student> fetch2()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		// Business Logic
		Query query=session.createQuery("from Student");
		List<Student> l1=query.list();
		for(Student s:l1)
		{
			System.out.println(s);
		}

		trans.commit();
		session.close();
		return l1;
	}
}
