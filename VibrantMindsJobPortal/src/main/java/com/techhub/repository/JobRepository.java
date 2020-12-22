package com.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.model.AdminModel;

@Repository("jobRepo")
public interface JobRepository extends JpaRepository<AdminModel, Integer> {

}
