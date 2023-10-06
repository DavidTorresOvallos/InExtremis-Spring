package com.example.inextremis.inextremis.model;


import java.sql.Date;

import com.example.inextremis.inextremis.model.enumeration.TypeMachineENUM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "INVENTORY")
public class InventoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "DatePiurchase")
    private Date datePurchase;
    @Column(name = "Price")
    private Double price;

    //Upward Connections
    @ManyToOne
    private TypeInventoryModel type_inventory;

    
    //ENUM
    @Enumerated(EnumType.STRING)
    private TypeMachineENUM typeMachine;
}
