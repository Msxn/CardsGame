package com.mydigitalschool.cardsgame.demo.cartes.classique;

import com.mydigitalschool.cardsgame.demo.cartes.Carte;
import com.mydigitalschool.cardsgame.demo.cartes.ICarteMemory;


/**
 * Classe CarteClassique avec Interface ICarte : objet de type Carte qui est instancié à chaque création de carte.<br>
 * C'est aussi elle qui nous permet d'interagir avec une carte via les interfaces ICarte/ICarteMemory
 * @author Matthieu Collette - MyDigitalSchool
 */
public abstract class CarteClassique extends Carte implements ICarteMemory {

    private final Atout atout;
    private final Valeur valeur;



    @Override
    public boolean estCompatible(ICarteMemory carte) {
        return false;
    }

    public String toString() {
        String visuel = "[--------]";
        if(this.isVisible()) {
            visuel = "[" + atout + ", " + valeur + "]";
        }
        return visuel;
    }



    public String atout_toString() {
        String atoutString = "" + getAtout();
        return atoutString.substring(0, 1);
    }

    public String couleur_toString() {
        String atoutString = "" + getAtout();
        return atoutString.substring(2, 4);
    }

    public String valeur_toString() {
        String valeurString = "" + getValeur();
        return valeurString;
    }

    public String allClearToString() {
        String allString = (valeur_toString().replaceAll(" ", ""))+atout_toString();
        return allString;
    }



    //GETTERS SETTERS
    public Atout getAtout() {
        return atout;
    }


    public Valeur getValeur() {
        return valeur;
    }




    public CarteClassique(Atout atout, Valeur valeur) {
        super();
        this.atout = atout;
        this.valeur = valeur;
    }





}

