package com.mijale.adaapp.Entidades;

public class Persona {
    private String nombredentro;
    private String textodentro;
    private int imagenId;

    public Persona(){

    }
    public Persona(String nombredentro, String textodentro, int imagenId) {
        this.nombredentro = nombredentro;
        this.textodentro = textodentro;
        this.imagenId = imagenId;
    }

    public String getNombredentro() {
        return nombredentro;
    }

    public void setNombredentro(String nombredentro) {
        this.nombredentro = nombredentro;
    }

    public String getTextodentro() {
        return textodentro;
    }

    public void setTextodentro(String textodentro) {
        this.textodentro = textodentro;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
