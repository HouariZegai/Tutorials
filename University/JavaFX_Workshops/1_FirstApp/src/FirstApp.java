import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstApp extends Application {
    @Override
    public void start(Stage stage) {
        Button btn = new Button("Say Hello!");

        VBox root = new VBox();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}