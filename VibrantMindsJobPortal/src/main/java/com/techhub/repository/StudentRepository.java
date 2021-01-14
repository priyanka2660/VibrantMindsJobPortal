package com.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.model.StudentModel;

@Repository("studProfileRepo")
public interface StudentRepository extends JpaRepository<StudentModel, Integer> 
{

}
