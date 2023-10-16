package com.example.inextremis.inextremis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inextremis.inextremis.model.GymModel;



@Repository
public interface GymRepository extends JpaRepository<GymModel, Long>{
    //Optional<GymModel> findGymByName(String name);
    //public abstract ArrayList<GymModel> findByPriority(Integer priority);
}