package com.mydigitalschool.cardsgame.demo.jeu.memory;

import com.mydigitalschool.cardsgame.demo.joueur.Joueur;

public class ControllerInitJoueurs {

    //TODO javadoc

    public static String n, p;
    public static int mode = 0, nbJoueurs = 0;

    public ControllerInitJoueurs() {}

    public static int initTabJoueurs() {

        System.out.println("Nombre de joueurs (1 à 4) : ");

        while(nbJoueurs<1 || nbJoueurs>4) nbJoueurs = ModelMemory.scanf.nextInt();

        for(int i=0; i<nbJoueurs; i++) {

            System.out.println("Entrer un nom : ");
            n = ModelMemory.scanf.next();
            System.out.println("Entrer un prénom : ");
            p = ModelMemory.scanf.next();

            if(n != "" && p != "") {
                System.out.println("Bienvenue "+ p + " " + n);
                ModelMemory.addJoueur(new Joueur(n, p));
            }

        }

        System.out.println("Quel mode souhaitez vous? (1=>Console ; 2=>Swing ; 3=>JavaFX) : ");
        while(mode<1 || mode>3) mode = ModelMemory.scanf.nextInt();



        System.out.println(ModelMemory.joueurs.size() + " joueurs");

        return mode;

    }





}
