package com.example.inextremis.inextremis.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inextremis.inextremis.model.LicenseModel;
import com.example.inextremis.inextremis.repository.LicenseRepository;

@Service
public class LicenseService {
    @Autowired
    private LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public ArrayList<LicenseModel> getAllLicenses(){
        return (ArrayList<LicenseModel>)licenseRepository.findAll();
    }

    public LicenseModel saveLicense(LicenseModel license){
        return this.licenseRepository.save(license);
    }

    public Optional<LicenseModel> getLicenseById(Long id){
        return this.licenseRepository.findById(id);
    }

    public boolean deleteLicense(Long id){
        if(licenseRepository.existsById(id)){
            try{
                licenseRepository.deleteById(id);
                return true;
            }catch(Exception e){
                return false;
            } 
        } else {
            return false;
        }
    }
}
