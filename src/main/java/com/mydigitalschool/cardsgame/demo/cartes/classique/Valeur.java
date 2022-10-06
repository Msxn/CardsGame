package com.mydigitalschool.cardsgame.demo.cartes.classique;

public enum Valeur {

    //TODO javadoc

    SEPT(" 7"),HUIT(" 8"),NEUF(" 9"),DIX("10"),VALET(" J"),DAME(" Q"),ROI(" K"),AS(" A");

    private String force;

    Valeur(String caractere) {
        this.force = caractere;
    }

    public String toString() {
        return this.force;
    }
}
