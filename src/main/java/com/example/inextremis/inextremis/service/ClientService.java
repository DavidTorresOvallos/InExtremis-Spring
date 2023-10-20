package com.example.inextremis.inextremis.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inextremis.inextremis.model.ClientModel;
import com.example.inextremis.inextremis.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public ArrayList<ClientModel> getAllClients(){
        return (ArrayList<ClientModel>)clientRepository.findAll();
    }

    public ClientModel saveClient(ClientModel client){
        return clientRepository.save(client);
    }

    public Optional<ClientModel> getById(Long id){
        return clientRepository.findById(id);
    }

    public boolean deleteClient(Long id){
        if(clientRepository.existsById(id)){
            try{
                clientRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
