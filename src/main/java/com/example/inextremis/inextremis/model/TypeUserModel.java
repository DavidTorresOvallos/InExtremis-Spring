package com.example.inextremis.inextremis.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TYPEUSER")
public class TypeUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;

    //Downward Connections
    @OneToMany(mappedBy = "type_user")
    private List<EmployeeModel> employees;
    
    @OneToMany(mappedBy = "type_user")
    private List<ClientModel> clients;

    //Upward Connections
    @OneToOne(mappedBy = "type_user")
    private PersonModel person;

}
