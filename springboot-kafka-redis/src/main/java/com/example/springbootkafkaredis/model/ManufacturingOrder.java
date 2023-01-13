package com.example.springbootkafkaredis.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mo")
public class ManufacturingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moID")
    private int moID;

    @Column(name = "status")
    private String status;

    @Column(name = "dateOfMO")
    private Date dateOfMO;

    @Column(name = "client_name")
    private String client_name;

    @Column(name = "dateOfDL")
    private Date dateOfDL;

    @Column(name = "dateOfSt")
    private Date dateOfSt;

    @Column(name = "dateOfEC")
    private Date dateOfEC;


    @ManyToMany(mappedBy = "mo", cascade = CascadeType.ALL)
    private Collection<ProductLine> productLines = new ArrayList<>();

    public int getMoID() {
        return moID;
    }

    public void setMoID(int moID) {
        this.moID = moID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfMO() {
        return dateOfMO;
    }

    public void setDateOfMO(Date dateOfMO) {
        this.dateOfMO = dateOfMO;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public Date getDateOfDL() {
        return dateOfDL;
    }

    public void setDateOfDL(Date dateOfDL) {
        this.dateOfDL = dateOfDL;
    }

    public Date getDateOfSt() {
        return dateOfSt;
    }

    public void setDateOfSt(Date dateOfSt) {
        this.dateOfSt = dateOfSt;
    }

    public Date getDateOfEC() {
        return dateOfEC;
    }

    public void setDateOfEC(Date dateOfEC) {
        this.dateOfEC = dateOfEC;
    }

}
