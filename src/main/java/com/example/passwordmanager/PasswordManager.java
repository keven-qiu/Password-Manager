package com.example.passwordmanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordManager extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Password Manager");
        GraphicalPasswordClient gpc = new GraphicalPasswordClient();

        gpc.getSaveBtn().setOnAction(actionEvent -> {
            // saving credentials
            gpc.getActionTarget().setFill(Color.FIREBRICK);
            gpc.getActionTarget().setText("Password saved");
        });

        gpc.getGenerateBtn().setOnAction(actionEvent -> {
            // generating random password
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