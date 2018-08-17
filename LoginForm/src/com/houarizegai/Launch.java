package com.houarizegai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/houarizegai/login/Login.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
