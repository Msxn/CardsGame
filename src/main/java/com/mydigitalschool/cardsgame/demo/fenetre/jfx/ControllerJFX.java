package com.mydigitalschool.cardsgame.demo.fenetre.jfx;

import com.mydigitalschool.cardsgame.demo.cartes.paquet.Paquet32;
import com.mydigitalschool.cardsgame.demo.jeu.memory.ControllerMemory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.mydigitalschool.cardsgame.demo.fenetre.swing.ControllerSwing.getCurrentPaquet;

public class ControllerJFX{

    public static Path currentRelativePath = Paths.get("");

    String image = "file:C:\\Users\\Matthieu\\IdeaProjects\\demo\\src\\images\\";
    ImageView imageView;

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

    public void setCurrentPaquet(Paquet32 current) {
        currentPaquet = current;
    }



}