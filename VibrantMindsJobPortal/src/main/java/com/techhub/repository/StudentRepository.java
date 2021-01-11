package com.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techhub.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> 
{

}
