package com.example.inextremis.inextremis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inextremis.inextremis.model.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long>{
    
}
