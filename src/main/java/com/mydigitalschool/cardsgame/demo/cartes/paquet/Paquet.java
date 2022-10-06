package com.mydigitalschool.cardsgame.demo.cartes.paquet;


import java.util.ArrayList;
import java.util.Collections;

import com.mydigitalschool.cardsgame.demo.cartes.ICarte;

public abstract class Paquet<T extends ICarte>{

    //TODO javadoc

    private ArrayList<T> paquetCartes = new ArrayList<T>();



    public boolean add(T carte) {
        return paquetCartes.add(carte);
    }

    public T remove(int i) {
        T carte = paquetCartes.get(i);
        paquetCartes.set(i, null);
        return carte;
    }

    public int size() {
        return paquetCartes.size();
    }

    public boolean isEmpty() {
        return paquetCartes.isEmpty();
    }

    public void melanger() {
        Collections.shuffle(this.paquetCartes);
    }



    public T get(int i) {
        return paquetCartes.get(i);
    }


    public String toString() {
        String visuel = "";
        int compteur = 1;
        for(T t : paquetCartes) {
            if(t != null) {
                visuel += t.toString();
            } else {
                visuel += "[---XX---]";
            }


            if(compteur % 6 == 0 && compteur != 0) {
                visuel += "\n";
            }
            compteur++;
        }
        return visuel;
    }


}
