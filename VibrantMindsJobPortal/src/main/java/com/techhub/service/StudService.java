package com.techhub.service;

import java.awt.color.CMMException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.techhub.model.StudentLoginModel;
import com.techhub.model.StudentModel;
import com.techhub.model.StudentRegisterModel;
import com.techhub.repository.StudRepository;
/*===================================student registration====================================*/
@Service("studSer")
public class StudService {
	
	@Autowired
	StudRepository studRepo;
	

	
	List<StudentRegisterModel>list=new ArrayList<StudentRegisterModel>();
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

	public StudentRegisterModel studValidation(StudentLoginModel m) {
		// TODO Auto-generated method stub
	   list=studRepo.findAll();

	   for(StudentRegisterModel c: list)
	   {
		   
		  		 
		   if((c.getEmail().equals(m.getEmail())) && (c.getPassword().equals(m.getPassword())))
		   {
		
			   return c;
		   }	   
		   
	   }
	   
		return null;
	}
/*=================================================================================================*/
	
}
