package com.example.inextremis.inextremis.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class InvoiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "Amount")
    private Integer Amount;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "Details")
    private String Details;
    @Column(name = "Value")
    private Double value;

    //Upward Connections
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "INVOICE_TYPEINVENTORY", joinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "type_inventory_id", referencedColumnName = "id")
    )
    private List<TypeInventoryModel> type_inventory;
}
