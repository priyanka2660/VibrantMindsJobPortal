package com.techhub.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.techhub.model.StudentModel;
import com.techhub.repository.StudentRepository;

@Service("studProfileSer")
public class StudProfileService {
/*=========================================parameters============================================================*/
	@Autowired
	StudentRepository studProfileRepo;
	
	
/*====================================================================================================*/	
	
	/*========================================student Profile==========================================*/	
	public StudentModel Studsave(StudentModel p )
	{
	   
		StudentModel b=studProfileRepo.save(p);
		
		return b;
	  
	}	
/*=================================================================================================*/
	

}
