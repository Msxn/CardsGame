package com.mydigitalschool.cardsgame.demo.joueur;

public class Joueur {

    //TODO javadoc

    private String nom;
    private String prenom;
    private int score;



    public Joueur(String n, String p) {
        nom = n;
        prenom = p;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void updateScore() {
        this.score++;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return this.prenom + " " + this.nom;
    }
}
