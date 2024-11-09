package com.kodoro.kodoro.dto;

import java.util.List;

public class ResultTabUsuel {
    private String designation;
    private double quantite;
    private double prixRevient;
    private double prixVente;
    private double reste;

    public ResultTabUsuel(String designation, double quantite, double prixRevient, double prixVente) {
        this.designation = designation;
        this.quantite = quantite;
        this.prixRevient = prixRevient;
        this.prixVente = prixVente;
    }
    public ResultTabUsuel(String designation, double quantite, double prixRevient, double prixVente,double reste ) {
        this.designation = designation;
        this.quantite = quantite;
        this.prixRevient = prixRevient;
        this.prixVente = prixVente;
        this.reste = reste;
    }
    /*  Calculer */
    public double getBenefice(){
        return this.prixVente - this.prixRevient;
    }
    public static double getSommeRevient(List<ResultTabUsuel> liste){
        double somme = 0;
        for (int i = 0; i < liste.size() ; i++) {
            somme+=liste.get(i).getPrixRevient();
        }
        return somme;
    }
    public static double getSommeVente(List<ResultTabUsuel> liste){
        double somme = 0;
        for (int i = 0; i < liste.size() ; i++) {
            somme+=liste.get(i).getPrixVente();
        }
        return somme;
    }
    /*---------- */
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public double getPrixRevient() {
        return prixRevient;
    }
    public void setPrixRevient(double prixRevient) {
        this.prixRevient = prixRevient;
    }
    public double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }
    public double getReste() {
        return reste;
    }
    public void setReste(double reste) {
        this.reste = reste;
    }    
}
