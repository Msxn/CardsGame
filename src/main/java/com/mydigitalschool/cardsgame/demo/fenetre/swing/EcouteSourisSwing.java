package com.mydigitalschool.cardsgame.demo.fenetre.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe EcouteSouris, utilisée par chaque bouton lorqu'on clique dessus, récupère<br>
 * l'index puis le passe dans la fonction onClick du Controleur concerné
 */
public class EcouteSourisSwing extends MouseAdapter {


    private final int index;

    public EcouteSourisSwing(int i) {
        this.index = i;
        System.out.println("bouton " + i + " créé");
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("click bouton " + getIndex());
        ControllerSwing.onClick(getIndex());

    }

    public int getIndex() {
        return index;
    }

}