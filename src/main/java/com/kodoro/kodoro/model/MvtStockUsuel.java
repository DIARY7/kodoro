package com.kodoro.kodoro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mvtStockUsuel")
public class MvtStockUsuel {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @ManyToOne
    @JoinColumn(name="id_fab",referencedColumnName = "id")
    Fabrication fab;

    double entree;
    double sortie;
    LocalDate daty;

    public MvtStockUsuel() {
    
    }
    public MvtStockUsuel(Fabrication fab){
        setDaty(fab.getDaty());
        setEntree(fab.getQuantite());
        setFab(fab);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fabrication getFab() {
        return fab;
    }

    public void setFab(Fabrication fab) {
        this.fab = fab;
    }

    public double getEntree() {
        return entree;
    }

    public void setEntree(double entree) {
        this.entree = entree;
    }

    public double getSortie() {
        return sortie;
    }

    public void setSortie(double sortie) {
        this.sortie = sortie;
    }
    public LocalDate getDaty() {
        return daty;
    }
    public void setDaty(LocalDate daty) {
        this.daty = daty;
    }    
}
