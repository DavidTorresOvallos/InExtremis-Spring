package com.example.inextremis.inextremis.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    //Atributes
    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Created")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    //Downward Connections
    @OneToMany(mappedBy = "gym")
    private List<PersonModel> people;

    @OneToMany(mappedBy = "gym")
    private List<LicenseModel> license;

}
