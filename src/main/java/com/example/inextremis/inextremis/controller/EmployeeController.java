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

import com.example.inextremis.inextremis.model.EmployeeModel;
import com.example.inextremis.inextremis.service.EmployeeService;

@RestController
@RequestMapping(path = "gym/people/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ArrayList<EmployeeModel> getEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @PostMapping()
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee){
        return this.employeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/{id}")
    public Optional<EmployeeModel> getEmployeeById(@PathVariable Long id){
        return this.employeeService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        boolean ok = this.employeeService.deleteEmployee(id);
        if(ok){
            return "Se eliminó el empleado " + id + "   con éxito";
        } else {
            return "No se pudo elminar el empleado " + id + " por favor, verifique si existe";
        }
    }
}
