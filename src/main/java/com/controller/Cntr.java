package com.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.TaxModel;
import com.service.TaxService;

@Controller
public class Cntr {
	
	
	/*
	 * @Autowired private ModelAndView modelAndView;
	 */
	 @Autowired
	 private TaxService taxService;
	 
	@RequestMapping("/tax")
	public String t() {

		System.out.println("ram------------------------------------------------------Ram");
		return "input.jsp";

	}

	@RequestMapping("/compute")
	public ModelAndView compute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		int income = Integer.parseInt(req.getParameter("t1"));
		int age = Integer.parseInt(req.getParameter("t2"));

		
		TaxModel  taxModel=new TaxModel();
		taxModel.setIncome(income);
		taxModel.setAge(age);
		
		
		
	//	TaxService taxService=new TaxService();
		
	  
		
	 taxModel=	taxService.computeTax(taxModel);

	 ModelAndView modelAndView=new  ModelAndView();
	 modelAndView.addObject("taxModel",taxModel);
	 modelAndView.setViewName("result.jsp");
	 
	 
	return modelAndView;
	}

}
