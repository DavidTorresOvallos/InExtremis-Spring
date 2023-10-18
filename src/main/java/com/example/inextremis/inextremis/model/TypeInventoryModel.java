package com.example.inextremis.inextremis.model;


import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "TYPEINVENTORY")
public class TypeInventoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;

    //Downward Connections
    @OneToMany(mappedBy = "type_inventory")
    private List<InventoryModel> inventory;

    //Upward Connections
    @ManyToMany(mappedBy = "type_inventory")
    private List<InvoiceModel> invoices;
}
