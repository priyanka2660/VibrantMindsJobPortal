package com.techhub.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.techhub.model.StudentLoginModel;
import com.techhub.model.StudentModel;
import com.techhub.model.StudentRegisterModel;
import com.techhub.service.StudProfileService;
import com.techhub.service.StudService;

@Controller
public class StudentController {

/*===========================================parameters=========================================*/
	
	@Autowired
	StudService studSer;
	String str;
    
	@Autowired
	StudProfileService studProfileSer; 
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
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
	
	@GetMapping("/studprofile")
	public String getprofile()
	{
		return "StudentProfile";
	}
	
	@PostMapping("/studsave")
	public String saveProfile(StudentModel s,Model m  )
	{
	
		StudentModel c=studProfileSer.Studsave(s);
		if(c != null)
		{
			str="Recored save Successfully" ;
			m.addAttribute("promsg",str);
		}	
		else
		{
			str="Recored save failed.."; 
			m.addAttribute("promsg",str);
		}	
		
		return "StudentProfile";
	}
/*=============================================================================================*/	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
