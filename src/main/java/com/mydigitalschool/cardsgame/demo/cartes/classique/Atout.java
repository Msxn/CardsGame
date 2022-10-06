package com.mydigitalschool.cardsgame.demo.cartes.classique;

public enum Atout {

    //TODO javadoc

    PIQUE("s", "No"), COEUR("h", "Ro"), CARREAU("d", "Ro"), TREFLE("c", "No");

    private String visuel;
    private String couleur;

    Atout(String caractere, String couleur) {
        this.visuel = caractere;
        this.couleur = couleur;
    }

    public String toString() {
        return this.visuel + " " + this.couleur;
    }
}
