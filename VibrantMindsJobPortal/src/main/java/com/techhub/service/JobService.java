package com.techhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.model.AdminModel;
import com.techhub.repository.JobRepository;

@Service("jobSer")
public class JobService {
	
	@Autowired
	JobRepository jobRepo;

	
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
}
