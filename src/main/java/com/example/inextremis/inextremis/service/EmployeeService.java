package com.example.inextremis.inextremis.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inextremis.inextremis.model.EmployeeModel;
import com.example.inextremis.inextremis.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public ArrayList<EmployeeModel> getAllEmployees(){
        return (ArrayList<EmployeeModel>)employeeRepository.findAll();
    }

    public EmployeeModel saveEmployee(EmployeeModel employee){
        return employeeRepository.save(employee);
    }

    public Optional<EmployeeModel> getById(Long id){
        return employeeRepository.findById(id);
    }

    public boolean deleteEmployee(Long id){
        if(employeeRepository.existsById(id)){
            try{
                employeeRepository.deleteById(id);
                return true;
            } catch(Exception ex) {
                return false;
            }
        } else {
            return false;
        }
    }
} 
