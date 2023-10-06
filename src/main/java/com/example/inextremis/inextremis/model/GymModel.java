package com.example.inextremis.inextremis.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "GYM")
public class GymModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //Atributes
    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Created")
    private Date created;

    //Downward Connections
    @OneToMany(mappedBy = "gym")
    private List<PersonModel> people;

    @OneToMany(mappedBy = "gym")
    private List<LicenseModel> license;
}
