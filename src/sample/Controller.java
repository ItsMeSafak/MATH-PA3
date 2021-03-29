package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private TextField valueOfN;
    @FXML private TextField valueOfP;
    @FXML private TextField valueOfQ;

    @FXML
    private void calculatePAndQ(ActionEvent event) {
        event.consume();

    }
}
