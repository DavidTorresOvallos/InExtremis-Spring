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

import com.example.inextremis.inextremis.model.ClientModel;
import com.example.inextremis.inextremis.service.ClientService;

@RestController
@RequestMapping(path = "gym/people/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ArrayList<ClientModel> getClients(){
        return (ArrayList<ClientModel>)clientService.getAllClients(); 
    }

    @PostMapping()
    public ClientModel saveClient(@RequestBody ClientModel client){
        return this.clientService.saveClient(client);
    }

    @GetMapping(path = "/{id}")
    public Optional<ClientModel> getClientById(@PathVariable Long id){
        return this.clientService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteClient(@PathVariable Long id){
        boolean ok = this.clientService.deleteClient(id);
        if(ok){
            return "Se eliminó el cliente " + id + " con éxito";
        } else {
            return "No se pudo eliminar el cliente" + id + ", por favor, verifique si existe";
        }
    }
}
