package com.pos.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    public static void loadView(Stage stage){
        try {
            Parent p = FXMLLoader.load(Login.class.getResource("Login.fxml"));
            stage.setScene(new Scene(p));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
