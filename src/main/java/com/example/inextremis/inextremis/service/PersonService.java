package com.example.inextremis.inextremis.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inextremis.inextremis.model.PersonModel;
import com.example.inextremis.inextremis.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public ArrayList<PersonModel> getPeople(){
        return (ArrayList<PersonModel>)personRepository.findAll();
    }

    public PersonModel savePerson(PersonModel person){
        return personRepository.save(person);
    }

    public Optional<PersonModel> getById(Long id){
        return personRepository.findById(id);
    }

    public boolean deleteById(Long id){
        if(personRepository.existsById(id)){
            try{
                personRepository.deleteById(id);
                return true;
            }catch(Exception err){
                return false;
            }
        } else {
            return false;
        }   
    }
}
