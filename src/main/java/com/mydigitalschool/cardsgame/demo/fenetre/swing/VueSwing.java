package com.mydigitalschool.cardsgame.demo.fenetre.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mydigitalschool.cardsgame.demo.cartes.paquet.Paquet32;

public abstract class VueSwing extends ControllerSwing{

    //TODO gestion de la fenetre
    //TODO javadoc

    private static final int LARGEUR = 500;
    private static final int HAUTEUR = 700;


    public VueSwing(Paquet32 paquetEnCours) {
        super(paquetEnCours);
    }


    public static void ouvrirFenetre() {
        panneau.setLayout(new GridBagLayout());
        panneau.setBackground(Color.decode("#006600"));
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(1, 3, 3, 1);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 3;
        gc.weighty = 3;
        JLabel button;
        int increment = 0;
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                if(increment<32) {
                    gc.gridx      = j;
                    gc.gridy      = i;
                    gc.gridwidth  = 1;
                    gc.gridheight = 1;
                    button = new JLabel();
                    button.setPreferredSize(new Dimension(15,15));
                    button.addMouseListener(new EcouteSouris(increment));
                    arrayLabels.add(button);
                    System.out.println(increment);
                    panneau.add(arrayLabels.get(increment), gc);
                    increment++;
                }
            }
        }


        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.add(panneau);
        fenetre.setSize(LARGEUR, HAUTEUR);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);


        updateFenetre();
    }


}
