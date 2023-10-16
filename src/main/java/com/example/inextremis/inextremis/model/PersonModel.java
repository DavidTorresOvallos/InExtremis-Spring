package com.example.inextremis.inextremis.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PERSON")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "LastNameOne")
    private String lastNameOne;
    @Column(name = "LastNameTwo")
    private String lastNameTwo;
    @Column(name = "Document")
    private String document;
    @Column(name = "NumDocument")
    private String numDocument;
    @Column(name = "DateBirth")
    private LocalDate dateBirth;
    @Column(name = "Created")
    private LocalDate created;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "ConfirmPassword")
    private String confirmPassword;
    @Column(name = "Contact")
    private String contact;
    @Column(name = "Image")
    private String image;

    @OneToOne
    private TypeUserModel type_user;

    @ManyToOne
    private GymModel gym;
}
