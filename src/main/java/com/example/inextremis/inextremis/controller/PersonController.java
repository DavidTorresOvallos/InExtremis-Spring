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

import com.example.inextremis.inextremis.model.PersonModel;
import com.example.inextremis.inextremis.service.PersonService;

@RestController
@RequestMapping("/gym/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping()
    public ArrayList<PersonModel> getPeople(){
        return this.personService.getPeople();
    }

    @PostMapping()
    public PersonModel savePerson(@RequestBody PersonModel person){
        return this.personService.savePerson(person);
    }

    @GetMapping(path = "/{id}")
    public Optional<PersonModel> getPersonById(@PathVariable("id") Long id){
        return this.personService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePersonById(@PathVariable("id") Long id){
        boolean ok = this.personService.deleteById(id);
        if(ok){
            return "Se eliminó la persona con el id " + id + " de la base de datos";
        }else{
            return "No se pudo eliminar a la persona con el id: " + id + " por favor, verifique si existe";
        }
    }
}
