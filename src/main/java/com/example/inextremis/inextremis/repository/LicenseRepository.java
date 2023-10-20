package com.example.inextremis.inextremis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inextremis.inextremis.model.LicenseModel;

@Repository
public interface LicenseRepository extends JpaRepository<LicenseModel, Long> {
    
}
