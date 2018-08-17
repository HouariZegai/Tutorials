package com.houarizegai.login;

import com.houarizegai.dao.DBConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void onLogin() {
        if (!usernameField.getText().matches("[a-zA-Z0-9_]{4,}")) {
            return;
        }
        if (passwordField.getText().isEmpty()) {
            return;
        }

        int status = DBConnection.checkLogin(usernameField.getText().trim().toLowerCase(), passwordField.getText());

        switch (status) {
            case 0: {
                Stage stage = (Stage) usernameField.getScene().getWindow();

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/com/houarizegai/system/System.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene(root));
            }
            break;
            case -1:
                JOptionPane.showMessageDialog(null, "Connection Failed");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Username or password wrong");
                break;
        }
    }
}
