package com.techhub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.model.AdminModel;
import com.techhub.repository.HomeRepository;

@Service("ser")
public class HomeService {
	
	@Autowired
	HomeRepository s;
	List<AdminModel>list=new ArrayList<AdminModel>();

	public List<AdminModel> searchJob(String keyword)
	{
		list=s.search(keyword);
		
		return list;
	}
	
}
