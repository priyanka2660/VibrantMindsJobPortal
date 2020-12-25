package com.techhub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techhub.model.AdminModel;
import com.techhub.repository.JobRepository;



@Service("jobSer")
public class JobService {
	
	@Autowired
	JobRepository jobRepo;
	List<AdminModel> list=new ArrayList<AdminModel>();
	
	public AdminModel saveJob(AdminModel job)
	{
		
		AdminModel j= jobRepo.save(job);
		
		if(j != null)
		{
			return j;
		}	
		else
		{
			return null;
		}	
	}
	
	 public List<AdminModel> getData()
	   {
		 list=jobRepo.findAll();
		 
		 return list;
		   
	   }
	 
	 
	 public void deljob(int id)
	 {
		 jobRepo.deleteById(id);
		 
	 }
	 
	 public AdminModel findbyid(Integer id)
	 {
		AdminModel a=jobRepo.findById(id).orElse(null);
		return a;
		
		 
		 
	 }
}


  