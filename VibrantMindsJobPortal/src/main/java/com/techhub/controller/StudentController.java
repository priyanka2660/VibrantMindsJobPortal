package com.techhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.techhub.model.StudentRegisterModel;
import com.techhub.service.StudService;

@Controller
public class StudentController {

/*===========================================parameters=========================================*/
	
	@Autowired
	StudService studSer; 	
/*=====================================================================================*/
	

/*======================================= register =========================================================*/
	
	@PostMapping("/regsave")
	public String register(StudentRegisterModel d,Model m)
	{
		String str;
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
	     	
	     	return "redirect:/";
	}
	
	
	
	
	
	
	
/*===============================================================================================*/
	
}
