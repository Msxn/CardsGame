package com.mydigitalschool.cardsgame.demo.fenetre.console;

import com.mydigitalschool.cardsgame.demo.jeu.memory.ControllerMemory;
import com.mydigitalschool.cardsgame.demo.jeu.memory.ModelMemory;


/**
 * ControllerConsole : utilisé par ControllerMemory pour choisir les cartes via la console
 * @author Matthieu Collette - MyDigitalSchool
 */
public class ControllerConsole{

    public ControllerConsole() {}


    public void cardChoice() {

        int choixCarte;


        while(ControllerMemory.fin != true) {
            System.out.println("Quelle première carte souhaitez-vous sélectionner? ");
            choixCarte = ModelMemory.scanf.nextInt();
            while(choixCarte<0 || choixCarte>31) choixCarte = ModelMemory.scanf.nextInt();

            ControllerMemory.carte1 = choixCarte;
            ControllerMemory.choixCarte1();


            System.out.println("Et pour la deuxième? ");
            choixCarte = ModelMemory.scanf.nextInt();
            while(choixCarte<0 || choixCarte>31) choixCarte = ModelMemory.scanf.nextInt();

            ControllerMemory.carte2 = choixCarte;
            ControllerMemory.choixCarte2();


        }

    }

}
