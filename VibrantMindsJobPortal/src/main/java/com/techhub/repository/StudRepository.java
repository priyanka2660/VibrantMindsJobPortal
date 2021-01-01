package com.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techhub.model.StudentRegisterModel;

@Repository("studRepo")
public interface StudRepository extends JpaRepository<StudentRegisterModel, Integer> {

}
