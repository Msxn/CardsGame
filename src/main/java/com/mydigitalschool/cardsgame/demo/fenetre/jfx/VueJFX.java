package com.mydigitalschool.cardsgame.demo.fenetre.jfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * VueJFX : c'est ici que la fenêtre est créée avec toutes les cartes affichées sur un tableau de 6x6
 * @author Matthieu Collette - MyDigitalSchool
 */
public class VueJFX extends Application{

    public static List<Button> arrayButtons = new ArrayList<>();
    static String image = "file:C:\\Users\\Matthieu\\IdeaProjects\\demo\\src\\images\\";
    static ImageView imageView;

    public static Timer timerJFX = null;

    @Override
    public void start(Stage stage){

        int increment = 0;
        GridPane cardPanel = new GridPane();
        cardPanel.setAlignment(Pos.CENTER);
        Button button;

        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(increment<32) {
                    button = new Button();
                    button.setId("" + increment);
                    cardPanel.add(button, j, i);
                    button.setMinSize(71, 96);
                    button.setMaxSize(71, 96);
                    button.setOnAction(new EcouteSourisJFX(parseInt(button.getId())));

                    imageView = new ImageView(new Image(image+"Hidden.gif"));
                    button.setGraphic(imageView);

                    arrayButtons.add(button);
                    increment++;

                }
            }
        }

        //ControllerJFX.updateFenetre();

        Scene scene = new Scene(cardPanel, 500, 700);
        stage.setTitle("CardGame");
        stage.setScene(scene);
        stage.show();

        ControllerJFX.hideAllCards();

        //timer de 400ms à chaque fausse paire de carte retournée
        //doit être fait dans une classe de type Application
        timerJFX = new Timer(400, e -> Platform.runLater(() -> {
            ControllerJFX.hideAllCards();
            System.out.println("done");
            timerJFX.stop();
        }));

    }

    public static void launchingJFX() {
        launch();
    }


    public static void cacherCarte(int carte) {
        imageView = new ImageView(new Image(image+"Hidden.gif"));
        arrayButtons.get(carte).setGraphic(imageView);
    }


    public static void montrerCarte(int carte) {
        imageView = new ImageView(new Image(image+ControllerJFX.findCard(carte)+".gif"));
        System.out.println(image+ControllerJFX.findCard(carte));
        arrayButtons.get(carte).setGraphic(imageView);
    }

    public static void supprimerCarte(int carte){
        arrayButtons.get(carte).setDisable(true);
    }



}