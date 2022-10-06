package com.mydigitalschool.cardsgame.demo.fenetre.jfx;

import com.mydigitalschool.cardsgame.demo.cartes.paquet.Paquet32;
import com.mydigitalschool.cardsgame.demo.jeu.memory.ControllerMemory;

/**
 * Classe EcouteSouris, utilisée par chaque bouton lorqu'on clique dessus, récupère<br>
 * l'index puis le passe dans la fonction onClick du Controleur concerné
 * @author Matthieu COLLETTE - MyDigitalSchool
 */
public class ControllerJFX{


    public static Paquet32 currentPaquet;


    public ControllerJFX(Paquet32 paquet){

        this.currentPaquet = paquet;

    }

    public void initJFX() {
        VueJFX.launchingJFX();
    }



    public static void onClick(int carte) {

        if(ControllerMemory.carte1==null) {
            ControllerMemory.carte1 = carte;
            ControllerMemory.choixCarte1();
        }
        else if(ControllerMemory.carte2==null) {
            ControllerMemory.carte2 = carte;
            ControllerMemory.choixCarte2();
        }

    }

    public static Paquet32 getCurrentPaquet() {
        return currentPaquet;
    }

    public static void setCurrentPaquet(Paquet32 currentPaquet) {
        ControllerJFX.currentPaquet = currentPaquet;
    }


    public void hide(int carte){
        VueJFX.cacherCarte(carte);
    }

    public void show(int carte){
        VueJFX.montrerCarte(carte);
    }

    public static void hideAllCards(){
        ControllerMemory.hideAll();
    }

    public static void deleteCard(int carte){
        VueJFX.supprimerCarte(carte);
    }

    public static String findCard(int carte){
        return currentPaquet.get(carte).allClearToString();
    }


}