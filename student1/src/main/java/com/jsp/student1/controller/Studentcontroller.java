package com.jsp.student1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.student1.entity.Student;
import com.jsp.student1.service.Studentservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Studentcontroller {
	@Autowired
	private Studentservice ss;
	@RequestMapping(value = "/insert" ,method = RequestMethod.GET)
	public ModelAndView insert(HttpServletRequest req,HttpServletResponse resp)
	{
		int sId=Integer.parseInt(req.getParameter("sId"));
		String sName=req.getParameter("sName");
		int sMarks=Integer.parseInt(req.getParameter("sMarks"));
		System.out.println(sId);
		System.out.println(sName);
		System.out.println(sMarks);

		ss.insert1(sId, sName, sMarks);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS INSERTED SUCCESSFULLY");
		return mav;
	}
	@RequestMapping(value ="/update" ,method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest req,HttpServletResponse resp)
	{
		int sId=Integer.parseInt(req.getParameter("sId"));
		int sMarks=Integer.parseInt(req.getParameter("sMarks"));
		System.out.println(sId);
		System.out.println(sMarks);

		ss.update1(sId,sMarks);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS UPDATED SUCCESSFULLY");
		return mav;
	}
	@RequestMapping(value ="/delete" ,method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse resp)
	{
		int sId=Integer.parseInt(req.getParameter("sId"));
		System.out.println(sId);

		ss.delete1(sId);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS DELETED SUCCESSFULLY");
		return mav;
	}
	@RequestMapping(value ="/fetch" ,method = RequestMethod.GET)
	public ModelAndView fetch(HttpServletRequest req,HttpServletResponse resp)
	{
		List<Student> l1=ss.fetch1();

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output","DATA IS FETCHED SUCCESSFULLY");
		return mav;
	}
}
