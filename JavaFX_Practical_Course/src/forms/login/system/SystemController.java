package forms.login.system;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class SystemController {
    
    @FXML
    public void onClose() {
        Platform.exit();
    }
}
