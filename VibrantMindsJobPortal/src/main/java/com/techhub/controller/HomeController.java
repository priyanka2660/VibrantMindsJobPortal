package com.techhub.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techhub.model.AdminModel;
import com.techhub.service.HomeService;

@Controller
public class HomeController {
/*=============================================================================================*/	
	@Autowired
	HomeService ser;
	List<AdminModel> list=new ArrayList<AdminModel>();
/*=============================================================================================*/	
	
	
	@GetMapping("/searchspecific")
	public String goSearch(@RequestParam("name") String keyword,Model m)
	{
		list=ser.searchJob(keyword);
		for(AdminModel m1:list)
		{
			System.out.println(m1.getCname());
			
		}
		
		m.addAttribute("homeModel",list);
		
		return "index";
		
	}
	
	

}
