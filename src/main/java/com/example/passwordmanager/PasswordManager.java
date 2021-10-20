package com.example.passwordmanager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PasswordManager extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Password Manager");
        GraphicalPasswordClient gpc = new GraphicalPasswordClient();

        RandomPasswordGenerator rpg = new RandomPasswordGenerator();

        gpc.getSaveBtn().setOnAction(actionEvent -> {
            // saving credentials
            gpc.getActionTarget().setFill(Color.FIREBRICK);
            gpc.getActionTarget().setText("Password saved");
        });

        gpc.getGenerateBtn().setOnAction(actionEvent -> {
            // generating random password
            final Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.initOwner(stage);

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            Label websiteLabel = new Label("Login Page");
            grid.add(websiteLabel, 0, 1);

            TextField passwordField = new TextField();
            passwordField.setPrefWidth(300);
            grid.add(passwordField, 1, 1);

            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("This is a Dialog"));
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            popup.setScene(dialogScene);
            popup.show();
            rpg.getPassword(25, false, false, false, false);
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