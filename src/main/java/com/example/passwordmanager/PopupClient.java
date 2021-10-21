package com.example.passwordmanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupClient {
    public static void display(final Stage stage,
        final RandomPasswordGenerator rpg, final GraphicalPasswordClient gpc,
        final Clipboard clipboard) {

        final Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(stage);
        GridPane grid = getGridPane();

        getPopupText(grid);
        TextField lengthField = getLengthField(grid);
        TextField passwordField = getPasswordField(grid);

        Button generate = getButton(grid);

        generateAction(rpg, gpc, clipboard, lengthField, passwordField,
            generate);

        Scene popupScene = new Scene(grid, 400, 400);
        generate.requestFocus();
        popup.setScene(popupScene);
        popup.show();
    }

    private static Button getButton(GridPane grid) {
        Button generate = new Button("Generate");
        generate.setPrefSize(100, 20);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.getChildren().add(generate);
        grid.add(hBox, 1, 3);
        return generate;
    }

    private static TextField getPasswordField(GridPane grid) {
        TextField passwordField = new TextField();
        passwordField.setPrefWidth(300);
        grid.add(passwordField, 1, 2);
        return passwordField;
    }

    private static TextField getLengthField(GridPane grid) {
        TextField lengthField = new TextField();
        lengthField.setPromptText("Length:");
        lengthField.setPrefWidth(300);
        grid.add(lengthField, 1, 1);
        return lengthField;
    }

    private static void getPopupText(GridPane grid) {
        Text sceneTitle = new Text("Generate Random Password");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
    }

    private static GridPane getGridPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }

    private static void generateAction(RandomPasswordGenerator rpg,
        GraphicalPasswordClient gpc, Clipboard clipboard,
        TextField lengthField, TextField passwordField, Button generate) {
        generate.setOnAction(actionEvent -> {
            copyPasswordClipboard(rpg, gpc, clipboard, lengthField,
                passwordField);
        });
    }

    private static void copyPasswordClipboard(RandomPasswordGenerator rpg,
        GraphicalPasswordClient gpc, Clipboard clipboard,
        TextField lengthField, TextField passwordField) {

        if (!lengthField.getText().isEmpty())
            passwordField.setText(rpg.getPassword(Integer.parseInt(lengthField.getText()), true,
                true, true, true));

        ClipboardContent content = new ClipboardContent();
        content.putString(passwordField.getText());
        clipboard.setContent(content);
        gpc.setPasswordTF(clipboard.getString());
    }
}
