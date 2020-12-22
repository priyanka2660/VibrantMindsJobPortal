package com.techhub.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.model.AdminModel;
import com.techhub.model.LoginModel;
import com.techhub.service.JobService;

@Controller
public class ApplicationController {
	
/*========================Parameters========================*/

	@Autowired
	JobService jobSer;
	
	
/*===========================================================*/	
	
	
	/*================home page========================================*/
	@GetMapping("/")
	public String goHome()
	{
		return "login";
	}
/*==================================================================================*/	

/*=======================AdminMaster========================================================================= */	
	@PostMapping( "/validate" )
	public String validateLogin(LoginModel model) {
		if (model.getUsername().equals("admin") && model.getPass().equals("admin")) {
			return "AdminMaster";
		} else {

			return "login";
		}
	
		}
/*======================================================================================*/
	
/*==================================new job======================================================*/
	@GetMapping("/newjob")
	public String NewJob()
	{
		return "NewJob";
	}
	
	@PostMapping("/savejob")
	public String saveJob(AdminModel a, Model m)
	{
		AdminModel e= jobSer.saveJob(a);
		String str;
		if(e != null)
		{
			str="Record Save Successfully";			
		}	
		else
		{
			str="There is Error";
		}	
		
		m.addAttribute("message",str);
		return "NewJob";
	}
/*========================================================================================*/	
	
/*=========================================view job========================================*/
	
	@GetMapping("/viewjob")
	public String viewjob( Model m)
	{
	      	
		return "ViewJob";
	}
	
	
	
	
/*=========================================================================================*/
	
	
	
	
	
}

