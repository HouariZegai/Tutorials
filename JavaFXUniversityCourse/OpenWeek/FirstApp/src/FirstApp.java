import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstApp extends Application {
    @Override
    public void start(Stage stage) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login Form !");
            stage.show();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
