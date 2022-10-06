package com.mydigitalschool.cardsgame.demo.fenetre.jfx;

import com.mydigitalschool.cardsgame.demo.cartes.paquet.Paquet32;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class VueJFX extends Application{

    public static List<Button> arrayButtons = new ArrayList<>();
    static String image = "file:C:\\Users\\Matthieu\\IdeaProjects\\demo\\src\\images\\";
    static ImageView imageView;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

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
/*
                    imageView = new ImageView(new Image(image+"Hidden.gif"));
                    button.setGraphic(imageView);
*/
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

}