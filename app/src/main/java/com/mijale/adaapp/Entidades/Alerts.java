package com.mijale.adaapp.Entidades;

public class Alerts {
    private String textoAlerts;
    private int imagenAlerts;

    public Alerts() {

    }

    public Alerts(String textoAlerts, int imagenAlerts) {

        this.textoAlerts = textoAlerts;
        this.imagenAlerts = imagenAlerts;
    }


    public String getTextoAlerts() {
        return textoAlerts;
    }

    public void setTextoAlerts(String textodentro) {
        this.textoAlerts = textodentro;
    }

    public int getImagenAlerts() {
        return imagenAlerts;
    }

    public void setImagenAlerts(int imagenId) {
        this.imagenAlerts = imagenId;
    }
}
