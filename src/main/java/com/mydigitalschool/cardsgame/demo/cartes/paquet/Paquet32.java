package com.mydigitalschool.cardsgame.demo.cartes.paquet;

import com.mydigitalschool.cardsgame.demo.cartes.classique.Atout;
import com.mydigitalschool.cardsgame.demo.cartes.classique.Carte32;
import com.mydigitalschool.cardsgame.demo.cartes.classique.Valeur;

public class Paquet32 extends Paquet<Carte32>{

    //TODO javadoc

    public Paquet32() {
        super();
        //TODO créer les 32 cartes avec values()

        //TODO creer le paquet


        for(Valeur valeur : Valeur.values()) {
            for (Atout atout : Atout.values()) {
                this.add(new Carte32(atout, valeur));
            }
        }
    }
}

