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
@Table(name="fabrication")
public class Fabrication {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name="id_usuel",referencedColumnName = "id")
    Usuel usuel;

    @ManyToOne
    @JoinColumn(name="id_bloc",referencedColumnName = "id")
    Bloc bloc;
    
    int quantite;
    LocalDate daty;



    public Fabrication() {
    }

    /*---------- */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuel getUsuel() {
        return usuel;
    }

    public void setUsuel(Usuel idUsuel) {
        this.usuel = idUsuel;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc idBloc) {
        this.bloc = idBloc;
    }

    public LocalDate getDaty() {
        return daty;
    }

    public void setDaty(LocalDate daty) {
        this.daty = daty;
    }
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
}
