package com.mydigitalschool.cardsgame.demo.jeu.memory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.mydigitalschool.cardsgame.demo.cartes.paquet.Paquet32;
import com.mydigitalschool.cardsgame.demo.fenetre.console.ControllerConsole;
import com.mydigitalschool.cardsgame.demo.fenetre.jfx.ControllerJFX;
import com.mydigitalschool.cardsgame.demo.fenetre.swing.ControllerSwing;

import static com.mydigitalschool.cardsgame.demo.fenetre.jfx.VueJFX.timerJFX;


/**
 * ControllerPPE class
 * Est appelée par Memory.class et permet de gérer le fonctionnement du panel de cartes<br>
 * Swing et console.
 *
 * @author Matthieu COLLETTE - MyDigitalSchool
 *
 */
public class ControllerMemory extends ModelMemory{


    /**
     * Carte1 et carte2 deux variables Integer qui récupèrent l'index de la carte cliquée<br>
     * et modeJeu le mode passé en paramètre du constructeur
     */
    public static Integer carte1 = null;
    public static Integer carte2 = null;
    public static int modeJeu;

    /**
     * paquetDe32Cartes le paquet qui contient toutes les cartes en objet List de type Paquet32
     */
    public static Paquet32 paquetDe32Cartes;

    /**
     * t un Timer qui nous permettra de réaliser des pauses à intervalle très courtes (- de 1s)
     */
    public static Timer t;


    /**
     * Constructeur ControllerPPE, détermine si le jeu doit être lancé en console, Swing ou JFX.<br>
     * En fonction du choix client, on ira chercher
     * @param mode Un entier reçu à l'instanciation du Controller qui détermine le mode de jeu
     */
    public ControllerMemory(int mode){

        paquetDe32Cartes = new Paquet32();
        modeJeu = mode;

        //MELANGE DE CARTES !
        //paquetDe32Cartes.melanger();

        switch (modeJeu) {
            case 1 -> {
                fenetreConsole = new ControllerConsole();
                fenetreConsole.cardChoice();
            }
            case 2 -> {
                fenetreSwing = new ControllerSwing(paquetDe32Cartes);
                fenetreSwing.fenetreEnCours();
            }
            case 3 -> {
                fenetreJFX = new ControllerJFX(paquetDe32Cartes);
                fenetreJFX.initJFX();
            }
            default -> {
                System.out.println("aucun mode sélectionné");
                return;
            }
        }

        hideAll();


    }



    /**
     * choixCarte1 et choixCarte2 deux méthodes qui sont choisies en fonction du premier<br>
     * ou deuxième clic par le controlleur IHM concerné
     */
    public static void choixCarte1() {

        if(carte1 < ControllerMemory.paquetDe32Cartes.size() && carte1 >= 0) {
            paquetDe32Cartes.get(carte1).retourner();
            showCard(carte1);
            System.out.println(paquetDe32Cartes);
        }
    }
    public static void choixCarte2() {

        if(carte2 < ControllerMemory.paquetDe32Cartes.size() && carte2 >= 0) {
            paquetDe32Cartes.get(carte2).retourner();
            showCard(carte2);
            System.out.println(paquetDe32Cartes);
            comparaison();

        }
    }


    /**
     * stopTimer une méthode appelée par notre timer t dans comparaison().<br>
     * Précaution pour éviter le bouclage du actionPerformed() dans le ActionListener
     */
    public static void stopTimer() {
        t.stop();
    }


    /**
     * comparaison, méthode qui permet de comparer la carte1 et la carte2 contenues dans paquetDe32Cartes<br>
     * Si l'atout et la couleur sont identiques, on supprime les 2 cartes du paquet et de l'IHM utilisée.<br>
     * Dans le cas contraire on retourne les cartes vues au moment du clic.
     */
    public static void comparaison() {

        if(modeJeu != 3){
            t = new Timer(400, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    hideAll();
                    stopTimer();
                }
            });
        }


        String couleur1 = paquetDe32Cartes.get(carte1).couleur_toString();
        String couleur2 = paquetDe32Cartes.get(carte2).couleur_toString();

        String val1 = paquetDe32Cartes.get(carte1).valeur_toString();
        String val2 = paquetDe32Cartes.get(carte2).valeur_toString();


        if(val1.equals(val2) && couleur1.equals(couleur2) && carte1 != carte2) {

            System.out.println("gagné "+couleur1+" "+couleur2);
            removeCard(carte1); removeCard(carte2 == 0 ? 0 : carte2);
            joueurs.get(currentPlayer).updateScore();

        }else {

            System.out.println("\nperdu\n");
            currentPlayer++;
            if(modeJeu !=3)
                t.start(); //on lance ici le timer correspondant aux modes console et swing
            else
                timerJFX.start(); //et ici le timer de JavaFX (pour l'instant en static directement dans la vue)
        }
        resetCartes();
        checkFin();
        currentPlayer = (joueurs.size() <= currentPlayer)? 0 : currentPlayer;

    }

    /**
     * removeCard, permet de supprimer la carte quel que soit le mode
     * @param carte la carte à supprimer/désactiver
     */
    public static void removeCard(int carte) {
        paquetDe32Cartes.remove(carte);
        if(modeJeu == 2) fenetreSwing.removeOnWindow(carte);
        if(modeJeu == 3) fenetreJFX.deleteCard(carte);
    }

    /**
     * removeCard, permet de cacher la carte quel que soit le mode
     * @param carte la carte à supprimer/désactiver
     */
    public static void hideCard(int carte) {
        paquetDe32Cartes.get(carte).cacher();
        if(modeJeu == 2) fenetreSwing.cacherCarte(carte);
        if(modeJeu == 3) fenetreJFX.hide(carte);
    }


    /**
     * removeCard, permet de cacher la carte quel que soit le mode
     * @param carte la carte à supprimer/désactiver
     */
    public static void showCard(int carte) {
        paquetDe32Cartes.get(carte).montrer();
        if(modeJeu == 2) fenetreSwing.montrerCarte(carte);
        if(modeJeu == 3) fenetreJFX.show(carte);
    }

    /**
     * hideAll, permet de cacher toutes les cartes d'un coup
     */
    public static void hideAll() {
        for(int i=0; i<ControllerMemory.paquetDe32Cartes.size(); i++) {
            if(paquetDe32Cartes.get(i) != null) {
                hideCard(i);
            }
        }
    }

    /**
     * resetCartes, permet de remettre à null les variables qui récupèrent l'id du choix des cartes
     */
    public static void resetCartes() {
        carte1 = null;
        carte2 = null;
    }


    /**
     * checkFin, permet de déterminer si les cartes sont toutes trouvées et d'appeler la fonction qui affichera le score de fin<br>
     * et qui permera le jeu
     */
    public static void checkFin() {
        fin = true;
        for(int i = 0; i<paquetDe32Cartes.size(); i++){
            if(paquetDe32Cartes.get(i) != null)
                fin = false;
        }
        if(fin){
            ModelMemory.finDuJeu();
        }
    }




}
