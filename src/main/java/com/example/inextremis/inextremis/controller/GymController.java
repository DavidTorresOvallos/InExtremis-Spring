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

import com.example.inextremis.inextremis.model.GymModel;
import com.example.inextremis.inextremis.service.GymService;

@RestController
@RequestMapping("/gym")
public class GymController {
    @Autowired
    private GymService gymService;

    public GymController(GymService gymService){
        this.gymService = gymService;
    }

    @GetMapping()
    public ArrayList<GymModel> getGyms(){
        return gymService.getGyms();
    }

    @PostMapping()
    public GymModel saveGym(@RequestBody GymModel gym){
        return this.gymService.saveGym(gym);
    }

    @GetMapping(path = "/{id}")
    public Optional<GymModel> getGymById(@PathVariable("id") Long id){
        return this.gymService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteGymById(@PathVariable("id") Long id){
        boolean ok = this.gymService.deleteGym(id);
        if(ok){
            return "Se eliminó el gimnasio " + id + " con éxito";
        }else{
            return "No se pudo eliminar el gimnasio " + id;
        }
    }
   /* 
    @PostMapping()
    public ResponseEntity<Object> saveGym(@RequestBody GymModel gym){
        return this.gymService.saveGym(gym);
    }
    */

}
