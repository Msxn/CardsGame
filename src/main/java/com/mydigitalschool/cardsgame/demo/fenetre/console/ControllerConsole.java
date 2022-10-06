package com.mydigitalschool.cardsgame.demo.fenetre.console;

import com.mydigitalschool.cardsgame.demo.jeu.memory.ControllerMemory;
import com.mydigitalschool.cardsgame.demo.jeu.memory.ModelMemory;

public class ControllerConsole{

    public ControllerConsole() {}


    public void cardChoice() {

        int choixCarte;

        //TODO javadoc
        //TODO animation de fin
        //TODO erreur nextString au moment de choisir les cartes
        //TODO affichage initial du jeu

        while(ControllerMemory.fin != true) {
            System.out.println("Quelle première carte souhaitez-vous sélectionner? ");
            choixCarte = ModelMemory.scanf.nextInt();
            ControllerMemory.carte1 = choixCarte;
            ControllerMemory.choixCarte1();
            System.out.println("Et pour la deuxième? ");
            choixCarte = ModelMemory.scanf.nextInt();
            ControllerMemory.carte2 = choixCarte;
            ControllerMemory.choixCarte2();

        }

    }

}
