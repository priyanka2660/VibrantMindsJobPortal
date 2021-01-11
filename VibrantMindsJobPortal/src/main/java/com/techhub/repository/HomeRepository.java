package com.techhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techhub.model.AdminModel;

@Repository("s")
public interface HomeRepository extends JpaRepository<AdminModel, Integer> 
{
	  @Query("SELECT p FROM AdminModel p WHERE p.name LIKE %?1%"
	            + " OR p.cname LIKE %?1%"
	            + " OR p.location LIKE %?1%" )
		public List<AdminModel> search(String keyword);

}
