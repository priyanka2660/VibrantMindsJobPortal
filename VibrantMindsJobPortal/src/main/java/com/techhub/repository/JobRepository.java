package com.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techhub.model.AdminModel;

@Repository("jobRepo")
public interface JobRepository extends JpaRepository<AdminModel, Integer> {
	
	List<AdminModel> list=new ArrayList<AdminModel>();
	
	@Query(" From AdminModel a where a.ldate >= current_date")
	public List<AdminModel> getDatabyDate();

}
