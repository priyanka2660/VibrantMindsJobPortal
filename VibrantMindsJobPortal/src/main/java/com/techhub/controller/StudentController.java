package com.techhub.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techhub.model.StudentLoginModel;
import com.techhub.model.StudentRegisterModel;
import com.techhub.service.StudService;

@Controller
public class StudentController {

/*===========================================parameters=========================================*/
	
	@Autowired
	StudService studSer;
	String str;

/*=====================================================================================*/
	

/*======================================= register =========================================================*/
	
	@PostMapping("/regsave")
	public String register( StudentRegisterModel d,Model m)
	{
	
		StudentRegisterModel s= studSer.save(d);
		if(s != null)
		{
			str="Registration Successfully";
		}	
		else
		{
			str="failed..";
		}	
		
	     	m.addAttribute("message",str);

		     	
	     	return "redirect:/studentlogin";
	}
	
	

		
		
	
/*===============================================================================================*/


	
/*======================================studentlogin=======================================================*/
	
	
	@GetMapping("/studentlogin")
	public String studlogin()
	{
		return "StudentLogin";
	}
	
	
	@PostMapping("/studlog")
	public String studlogvalidation(StudentLoginModel x, Model m)
	{
		StudentRegisterModel b=studSer.studValidation(x);
        m.addAttribute("student", b); 
		
		if(b != null)
		{
			return "StudentMaster";
		}	
		else
		{
			return "redirect:/";
		}	
		
	}
	

	
/*=============================================================================================*/	
	
	
/*============================================profile=================================================*/
	
	@GetMapping("studprofile")
	public String getprofile()
	{
		return "StudentProfile";
	}
	
/*=============================================================================================*/	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
