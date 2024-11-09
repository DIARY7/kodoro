package com.kodoro.kodoro.dto;

public class VolumeReste {
    double volume;
    double prixRevient;

    public VolumeReste(double volume,double prixRevient) {
        this.volume = volume;
        this.prixRevient=prixRevient;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPrixRevient() {
        return prixRevient;
    }

    public void setPrixRevient(double prixRevient) {
        this.prixRevient = prixRevient;
    }
}
