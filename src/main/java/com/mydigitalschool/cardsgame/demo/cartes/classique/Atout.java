package com.mydigitalschool.cardsgame.demo.cartes.classique;

/**
 * Enumérateur Atout, ce fichier nous permet de changer ou de rajouter les valeurs de cartes.<br>
 * Si ajout/modif de cartes, ajouter son image correspondante au format 'atout''valeur'.png
 */
public enum Atout {

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
