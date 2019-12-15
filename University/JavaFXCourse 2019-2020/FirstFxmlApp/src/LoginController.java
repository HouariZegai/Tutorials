import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField fieldName;

    @FXML
    void onLogin() {
        String name = fieldName.getText();
        System.out.println("Name: " + name);
    }
}
