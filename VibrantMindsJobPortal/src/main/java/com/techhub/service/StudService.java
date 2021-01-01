package com.techhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.model.StudentRegisterModel;
import com.techhub.repository.StudRepository;

@Service("studSer")
public class StudService {
	
	@Autowired
	StudRepository studRepo;
	
	public StudentRegisterModel save(StudentRegisterModel m)
	{
		StudentRegisterModel r= studRepo.save(m);
		
		if(r != null)
		{
			return r;
		}
		else
		{
			return null;
		}	
		
	}
}
