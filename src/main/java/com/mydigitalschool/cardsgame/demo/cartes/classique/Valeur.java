package com.mydigitalschool.cardsgame.demo.cartes.classique;

/**
 * Enumérateur Valeur, ce fichier nous permet de changer ou de rajouter des valeurs de cartes.<br>
 * Si ajout/modif de cartes, ajouter son image correspondante au format 'atout''valeur'.png
 */
public enum Valeur {

    SEPT(" 7"),HUIT(" 8"),NEUF(" 9"),DIX("10"),VALET(" J"),DAME(" Q"),ROI(" K"),AS(" A");

    private String force;

    Valeur(String caractere) {
        this.force = caractere;
    }

    public String toString() {
        return this.force;
    }
}
