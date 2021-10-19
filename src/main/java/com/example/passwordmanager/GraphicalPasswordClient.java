package com.example.passwordmanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GraphicalPasswordClient {
    private final GridPane grid;
    private final TextField websiteTF;
    private final TextField usernameTF;
    private final TextField passwordTF;
    private final Button saveBtn;
    private final Button generateBtn;
    private final Button clearBtn;
    private final Text actionTarget;

    public GraphicalPasswordClient() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Save passwords");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label websiteLabel = new Label("Login Page");
        grid.add(websiteLabel, 0, 1);

        websiteTF = new TextField();
        websiteTF.setPrefWidth(300);
        grid.add(websiteTF, 1, 1);

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 2);

        usernameTF = new TextField();
        usernameTF.setPrefWidth(300);
        grid.add(usernameTF, 1, 2);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 3);

        passwordTF = new TextField();
        passwordTF.setPrefWidth(300);
        grid.add(passwordTF, 1, 3);

        saveBtn = new Button("Save");
        saveBtn.setPrefSize(100, 20);

        generateBtn = new Button("Generate");
        generateBtn.setPrefSize(100, 20);

        clearBtn = new Button("Clear");
        clearBtn.setPrefSize(100, 20);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.getChildren().addAll(clearBtn, generateBtn, saveBtn);
        grid.add(hBox, 1, 4);


        actionTarget = new Text();
        grid.add(actionTarget, 1, 6);
    }

    public void clearTextFields() {
        websiteTF.clear();
        usernameTF.clear();
        passwordTF.clear();
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public Button getGenerateBtn() {
        return generateBtn;
    }

    public Button getClearBtn() {
        return clearBtn;
    }

    public GridPane getGrid() {
        return grid;
    }

    public String getWebsite() {
        return websiteTF.getText();
    }

    public String getUsername() {
        return usernameTF.getText();
    }

    public String getPassword() {
        return passwordTF.getText();
    }

    public void setWebsiteTF(String text) {
        websiteTF.setText(text);
    }

    public void setUsernameTF(String text) {
        usernameTF.setText(text);
    }

    public void setPasswordTF(String text) {
        passwordTF.setText(text);
    }

    public Text getActionTarget() {
        return actionTarget;
    }
}
