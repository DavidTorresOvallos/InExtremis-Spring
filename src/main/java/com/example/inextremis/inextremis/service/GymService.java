package com.example.inextremis.inextremis.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inextremis.inextremis.model.GymModel;
import com.example.inextremis.inextremis.repository.GymRepository;

@Service
public class GymService {
    @Autowired
    private GymRepository gymRepository;

    public GymService(GymRepository gymRepository){
        this.gymRepository = gymRepository;
    }

    public ArrayList<GymModel> getGyms(){
        return (ArrayList<GymModel>)gymRepository.findAll();
    }

    public GymModel saveGym(GymModel gym){
        return gymRepository.save(gym);
    }

    public Optional<GymModel> getById(Long id){
        return gymRepository.findById(id);
    }

    public boolean deleteGym(Long id){
        if(gymRepository.existsById(id)){
            try{
            gymRepository.deleteById(id);
            return true;
            }catch(Exception ex){
                return false;   
            }
        } else {
            return false;
        }
        
    }
/*
    public ResponseEntity<Object> saveGym(GymModel gym){
        Optional<GymModel> res = gymRepository.findGymByName(gym.getName());
        HashMap<String, Object> datos = new HashMap<>();

        if(res.isPresent()){
            datos.put("error", true);
            datos.put("message", "Ya existe un gimnasio con ese nombre");
            return new ResponseEntity<>(
                HttpStatus.CONFLICT 
            );
        }
        gymRepository.save(gym);
        datos.put("data", datos);
        datos.put("message", "Gimnasio guardado con éxito");
        return new ResponseEntity<>(
            datos,
            HttpStatus.CREATED
        );
    }
*/
}
