package com.mydigitalschool.cardsgame.demo.fenetre.jfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class EcouteSouris implements EventHandler<ActionEvent> {

    //TODO javadoc

    private final int index;

    public EcouteSouris(int i) {
        this.index = i;
        System.out.println("bouton " + i + " créé");
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("click bouton " + getIndex());
    }
}