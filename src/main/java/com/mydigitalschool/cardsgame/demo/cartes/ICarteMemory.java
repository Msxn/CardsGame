package com.mydigitalschool.cardsgame.demo.cartes;

import com.mydigitalschool.cardsgame.demo.cartes.classique.Atout;
import com.mydigitalschool.cardsgame.demo.cartes.classique.Valeur;

public interface ICarteMemory extends ICarte {

    public boolean estCompatible(ICarteMemory carte);
    public Atout getAtout();
    public Valeur getValeur();

}
