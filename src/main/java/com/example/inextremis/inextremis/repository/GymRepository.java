package com.example.inextremis.inextremis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inextremis.inextremis.model.GymModel;

public interface GymRepository extends JpaRepository<GymModel, Long>{
    
}
