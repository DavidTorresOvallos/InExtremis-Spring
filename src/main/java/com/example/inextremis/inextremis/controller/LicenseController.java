package com.example.inextremis.inextremis.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inextremis.inextremis.model.LicenseModel;
import com.example.inextremis.inextremis.service.LicenseService;

@RestController
@RequestMapping(path = "gym/license")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    @GetMapping()
    public ArrayList<LicenseModel> getLicense(){
        return this.licenseService.getAllLicenses();
    }

    @PostMapping()
    public LicenseModel saveLicense(@RequestBody LicenseModel license){
        return this.licenseService.saveLicense(license);
    }

    @GetMapping(path = "/{id}")
    public Optional<LicenseModel> getLicenseById(@PathVariable Long id){
        return this.licenseService.getLicenseById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteLicense(@PathVariable Long id){
        boolean ok = this.licenseService.deleteLicense(id);
        if(ok){
            return "Se eliminó la licencia " + id + " con éxito";
        } else {
            return "No se pudo eliminar la licencia " + id + " por favor, verifique si existe";
        }
    }
}
