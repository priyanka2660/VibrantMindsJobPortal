package com.techhub.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.techhub.model.AdminModel;
import com.techhub.model.LoginModel;
import com.techhub.service.JobService;

@Controller

public class ApplicationController {
	
/*========================Parameters========================*/

	@Autowired
	JobService jobSer;
	List<AdminModel> list=new ArrayList<AdminModel>();
	
/*===========================================================*/	
	
/*===============================Admin page=======================================*/
	
	@GetMapping("/admin")
	public String goAdmin(Model m)
	{
		String s= "admin"; 
		m.addAttribute("name",s);
		return "login";
	}
	

		
/*=========================================================================*/
	
	
	
	/*================home page========================================*/
	@GetMapping("/")
	public String goHome(Model m)
	{
	 list=jobSer.getDatabyDate();
	 m.addAttribute("homeModel",list);
	 return "index";
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
	public String goView(Model m)
	{
	 list=jobSer.getDatabyDate();
	 m.addAttribute("homeModel",list);
	 return "ViewCurrentJob";
	}
	
	
	
	
	@GetMapping("/viewjoball")
	public String viewjob( Model m)
	{
	    list=jobSer.getData();
	    m.addAttribute("jobModel",list);
		return "ViewJob";
	}	
/*=========================================================================================*/
	
	
/*=========================================Delete job=======================================*/
	
	@GetMapping("/Currentdelete/{id}")
	public String delete(@PathVariable("id") Integer id )
	{
	      jobSer.deljob(id);
	      return "redirect:/viewjob";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAll(@PathVariable("id") Integer id )
	{
	      jobSer.deljob(id);
	      return "redirect:/viewjoball";
	}
	
/*==========================================================================================*/
	
	
/*========================================Update Job================================================*/
	
       @GetMapping("/update/{id}" )
       public String update(@PathVariable("id") Integer id, Model m )
       { 
        AdminModel job=jobSer.findbyid(id);
        m.addAttribute("jobobj",job);
       
    	    return "UpdateJob";
       }	
       
       @PostMapping("/updateAll")
       public String updateAll(AdminModel m)
       {
    	   jobSer.saveJob(m);
    	   return "redirect:/viewjob";
       }
    	  
 /*===================================================================================================*/      
       

/*=======================================view job===================================================*/
       
       @GetMapping("/viewCurrentjob/{vid}" )
       public ModelAndView viewcurrentupdate(@PathVariable("vid") Integer vid )
       { 
       ModelAndView mv=new ModelAndView("ViewCurrentMore");
        AdminModel job=jobSer.findbyid(vid);
        mv.addObject("jobobj",job);
       
    	    return mv;
       } 
              
       @GetMapping("/viewjob/{vid}" )
       public ModelAndView viewupdate(@PathVariable("vid") Integer vid )
       { 
       ModelAndView mv=new ModelAndView("ViewMore");
        AdminModel job=jobSer.findbyid(vid);
        mv.addObject("jobobj",job);
       
    	    return mv;
       }
       
        @PostMapping("/deleteCurrentAll")
        public String deleteCurrentAll(AdminModel n)
        {
        	Integer sid=n.getJid();
        	jobSer.deljob(sid);
        	
        	return "redirect:/viewjob";
        }  
        
        @PostMapping("/deleteAll")
        public String deleteAll(AdminModel n)
        {
        	Integer sid=n.getJid();
        	jobSer.deljob(sid);
        	
        	return "redirect:/viewjoball";
        } 
/*==================================================================================================*/	
}

