package com.example.inextremis.inextremis.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "CLIENT")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    @Column(name = "Weight")
    private Integer weight;

    @Column(name = "Height")
    private Integer height;


    @ManyToOne
    private TypeUserModel type_user;

    @ManyToOne
    private LicenseModel license;
}
