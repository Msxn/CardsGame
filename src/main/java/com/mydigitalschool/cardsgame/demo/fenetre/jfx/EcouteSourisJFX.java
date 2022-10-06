package com.mydigitalschool.cardsgame.demo.fenetre.jfx;

import com.mydigitalschool.cardsgame.demo.fenetre.swing.ControllerSwing;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class EcouteSourisJFX implements EventHandler<ActionEvent> {

    //TODO javadoc

    private final int index;

    public EcouteSourisJFX(int i) {
        this.index = i;
        System.out.println("bouton " + i + " créé");
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("click bouton " + getIndex());
        ControllerJFX.onClick(getIndex());

    }
}