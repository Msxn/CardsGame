package com.mydigitalschool.cardsgame.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class VueJFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        int increment = 0;
        GridPane cardPanel = new GridPane();
        cardPanel.setAlignment(Pos.CENTER);

        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(increment<32) {
                    Button button = new Button("Card");
                    button.setId("" + increment);
                    increment++;
                    cardPanel.add(button, j, i);
                    button.setOnAction(new EcouteSouris(parseInt(button.getId())));
                }
            }
        }

        Scene scene = new Scene(cardPanel, 700, 500);
        stage.setTitle("CardGame");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}