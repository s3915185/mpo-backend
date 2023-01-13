package com.example.springbootkafkaredis.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int plID;

    @Column(name = "pID")
    private int pdID;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit")
    private String unit;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "mo_pl", joinColumns = @JoinColumn(name = "plID"), inverseJoinColumns = @JoinColumn(name = "moID"))
    private Collection<ManufacturingOrder> mo = new ArrayList<>();

    @Column(name = "moID")
    private int moID;

    public int getPlID() {
        return plID;
    }

    public void setPlID(int plID) {
        this.plID = plID;
    }

    public int getPdID() {
        return pdID;
    }

    public void setPdID(int pdID) {
        this.pdID = pdID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setMo(Set<ManufacturingOrder> mo) {
        this.mo = mo;
    }
}
