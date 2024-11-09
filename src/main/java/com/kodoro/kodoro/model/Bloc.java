package com.kodoro.kodoro.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Bloc {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @ManyToOne
    @JoinColumn(name = "id_origine", referencedColumnName = "id")
    private Bloc origine; // Utilisation de l'objet Bloc pour la relation
    
    @Column(name = "longueur", nullable = false)
    private double longueur;

    @Column(name = "largeur", nullable = false)
    private double largeur;

    @Column(name = "hauteur", nullable = false)
    private double hauteur;

    @Column(name = "daty", nullable = false)
    private LocalDate daty;

    @Column(name="prix_revient",nullable = false)
    private double prixRevient;

    // Constructeur par défaut
    public Bloc() {
        
    }
    public Bloc(double longueur,double largeur,double hauteur){
        setLongueur(longueur);
        setLargeur(largeur);
        setHauteur(hauteur);
    }
    /* Fonction complementaire */
    public double getVolume(){
        return this.longueur*this.largeur*this.hauteur;
    }
    public void checkDebordement(double totalVolume) throws Exception{
        if (totalVolume > this.getVolume()) {
            throw new Exception("Trop volumineux pour ce bloc");
        }
    }
    public double calculePrixRevient(){
        double pr =  (this.origine.getPrixRevient() * this.getVolume()) / this.origine.getVolume();
        return pr;
    }

    /* getters and setters */
    public int getId() {
        return id;
    }
    public double getValuePercentMarge(){
        double percentMarge = 100 - Constantes.margeMax;//98 raha 2
        double aAtteindre = (percentMarge*this.getVolume())/100;
        return aAtteindre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bloc getOrigine() {
        return origine;
    }

    public void setOrigine(Bloc idOrigine) {
        this.origine = idOrigine;
        setPrixRevient(calculePrixRevient());
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public LocalDate getDaty() {
        return daty;
    }

    public void setDaty(LocalDate daty) {
        this.daty = daty;
    }

    public double getPrixRevient() {
        return prixRevient;
    }

    public void setPrixRevient(double prixRevient) {
        this.prixRevient = prixRevient;
    }
}
