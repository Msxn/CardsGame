package com.mydigitalschool.cardsgame.demo.cartes.paquet;

import com.mydigitalschool.cardsgame.demo.cartes.classique.Atout;
import com.mydigitalschool.cardsgame.demo.cartes.classique.Carte32;
import com.mydigitalschool.cardsgame.demo.cartes.classique.Valeur;

public class Paquet32 extends Paquet<Carte32>{

    public Paquet32() {
        super();

        for(Valeur valeur : Valeur.values()) {
            for (Atout atout : Atout.values()) {
                this.add(new Carte32(atout, valeur));
            }
        }
    }
}

