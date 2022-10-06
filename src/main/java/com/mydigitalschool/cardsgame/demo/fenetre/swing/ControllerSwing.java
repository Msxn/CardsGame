package com.mydigitalschool.cardsgame.demo.fenetre.swing;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mydigitalschool.cardsgame.demo.cartes.paquet.Paquet32;
import com.mydigitalschool.cardsgame.demo.jeu.memory.ControllerMemory;

public class ControllerSwing {

    //TODO javadoc
    //TODO affichage score et joueur
    //TODO (facultatif regler bug souris)

    public static final String cheminIcones = "C:\\Users\\Matthieu\\eclipse-workspace\\speed\\src\\cartes\\images\\";
    public static List<JLabel> arrayLabels = new ArrayList<JLabel>();

    public static JFrame fenetre = new JFrame();
    public static JPanel panneau = new JPanel();

    public static Paquet32 currentPaquet;


    public ControllerSwing(Paquet32 paquetEnCours) {
        currentPaquet = paquetEnCours;
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


    public void fenetreEnCours() {
        VueSwing.ouvrirFenetre();
    }


    public void removeOnWindow(int carte) {
        panneau.remove(arrayLabels.get(carte));
        panneau.repaint();
    }

    public static void updateFenetre() {
        Paquet32 cartes = getCurrentPaquet();
        String imageChemin;
        for(int i=0; i<cartes.size(); i++) {
            imageChemin = cheminIcones+cartes.get(i).allClearToString() + ".gif";
            System.out.println(imageChemin);
            arrayLabels.get(i).setIcon(new ImageIcon(imageChemin));
        }
        panneau.repaint();

    }


    public void retournerCarte(int carte) {
        String imageChemin;
        Paquet32 cartes = getCurrentPaquet();
        System.out.println(cartes.get(carte).isVisible());
        if(!cartes.get(carte).isVisible()) {
            imageChemin = cheminIcones+"Hidden.gif";
        }else {
            imageChemin = cheminIcones+cartes.get(carte).allClearToString() + ".gif";
        }
        arrayLabels.get(carte).setIcon(new ImageIcon(imageChemin));
        System.out.println(imageChemin);
        panneau.repaint();

    }


    public void cacherCarte(int carte) {
        String imageChemin;
        imageChemin = cheminIcones+"Hidden.gif";
        arrayLabels.get(carte).setIcon(new ImageIcon(imageChemin));
        panneau.repaint();
    }


    public void montrerCarte(int carte) {
        String imageChemin;
        Paquet32 cartes = getCurrentPaquet();
        imageChemin = cheminIcones+cartes.get(carte).allClearToString() + ".gif";
        arrayLabels.get(carte).setIcon(new ImageIcon(imageChemin));
        panneau.repaint();
    }


    public static Paquet32 getCurrentPaquet() {
        return currentPaquet;
    }


    public void setCurrentPaquet(Paquet32 current) {
        currentPaquet = current;
    }




}
