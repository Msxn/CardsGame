package com.mydigitalschool.cardsgame.demo.fenetre.jfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Classe EcouteSouris, utilisée par chaque bouton lorqu'on clique dessus, récupère<br>
 * l'index puis le passe dans la fonction onClick du Controleur concerné
 */
public class EcouteSourisJFX implements EventHandler<ActionEvent> {


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