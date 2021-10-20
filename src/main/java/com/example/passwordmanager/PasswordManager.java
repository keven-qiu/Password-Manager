package com.example.passwordmanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordManager extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Password Manager");

        GraphicalPasswordClient gpc = new GraphicalPasswordClient();
        RandomPasswordGenerator rpg = new RandomPasswordGenerator();
        Clipboard clipboard = Clipboard.getSystemClipboard();

        gpc.getSaveBtn().setOnAction(actionEvent -> {
            // saving credentials, use JSON
            gpc.getActionTarget().setFill(Color.FIREBRICK);
            gpc.getActionTarget().setText("Password saved");
        });

        gpc.getGenerateBtn().setOnAction(actionEvent -> {
            PopupClient.display(stage, rpg, gpc, clipboard);
        });

        gpc.getClearBtn().setOnAction(actionEvent -> {
            gpc.clearTextFields();
        });

        Scene scene = new Scene(gpc.getGrid(), 500, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}