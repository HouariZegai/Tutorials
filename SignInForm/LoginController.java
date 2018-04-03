
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class LoginController implements Initializable {
    
    @FXML
    private VBox rightBox;
    
    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXPasswordField passwordField;
    
    JFXSnackbar errorMsg;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMsg = new JFXSnackbar(rightBox);
    }
    
    @FXML
    private void btnLogin() {
        if(usernameField.getText().isEmpty()) {
            errorMsg.show("Username is empty !", 1500);
            return;
        }
        if(passwordField.getText().isEmpty()) {
            errorMsg.show("Password is empty !", 1500);
            return;
        }
        System.out.println("Username : " + usernameField.getText());
        System.out.println("Password : " + passwordField.getText());
        
        errorMsg.show("Success !", 2000);
            
    }
    @FXML
    private void btnExit() {
        Platform.exit();
    }
    
    
}
