package com.mydigitalschool.cardsgame.demo.jeu.memory;

import java.util.ArrayList;
import java.util.Scanner;

import com.mydigitalschool.cardsgame.demo.fenetre.console.ControllerConsole;
import com.mydigitalschool.cardsgame.demo.fenetre.jfx.ControllerJFX;
import com.mydigitalschool.cardsgame.demo.fenetre.swing.ControllerSwing;
import com.mydigitalschool.cardsgame.demo.jeu.Jeu;
import com.mydigitalschool.cardsgame.demo.joueur.Joueur;

public class ModelMemory extends Jeu {

    //TODO javadoc

    public static ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    public static ControllerSwing fenetreSwing;
    public static ControllerConsole fenetreConsole;
    public static ControllerJFX fenetreJFX;
    public static int currentPlayer;
    public static Scanner scanf = new Scanner(System.in);
    public static boolean graph = true;
    public static boolean fin = false;


    public ModelMemory() {}

    public void Jouer() throws Exception {
        initJeu(graph);
        displayJoueurs();
        jeuSwing();
    }



    public void jeuSwing() {
        currentPlayer = 0;

    }


    public void initJeu(boolean graphique) throws Exception {

        int modeJeu = ControllerInitJoueurs.initTabJoueurs();
        new ControllerMemory(modeJeu);


    }




    public void afficherScore() {
        for(Joueur j : joueurs) {
            System.out.println("Score "+j.getPrenom()+" "+j.getNom()+" : "+j.getScore());
        }
    }


    public static void addJoueur(Joueur joueur) {
        ModelMemory.joueurs.add(joueur);
    }


    public void displayJoueurs() {
        for(int i=0; i<joueurs.size(); i++) {
            System.out.println(ModelMemory.joueurs.get(i).toString());
        }
    }






}
