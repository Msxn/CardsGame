package com.mydigitalschool.cardsgame.demo.fenetre.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EcouteSourisSwing extends MouseAdapter {

    //TODO javadoc

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