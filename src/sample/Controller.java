package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final String ERROR_MESSAGE_N = "The value of N is not valid";
    private final String ERROR_MESSAGE_E = "The value of E is not valid";

    private RSA rsa;

    @FXML private Label errorMessage;
    @FXML private Label exampleInput;
    @FXML private TextField valueOfN;
    @FXML private TextField valueOfP;
    @FXML private TextField valueOfQ;
    @FXML private TextField valueOfE;
    @FXML private TextField valueOfD;
    @FXML private TextField valueOfPHI;
    @FXML private TextArea valueOfEText;
    @FXML private TextArea valueOfEEncryptedText;
    @FXML private TextArea valueOfDEncryptedText;
    @FXML private TextArea valueOfDDecryptedText;

    @FXML
    private void calculatePAndQ() {
       if (valueOfN.getText().isEmpty()) {
           addErrorMessage(ERROR_MESSAGE_N);
           clearFields();
           return;
       }

        rsa = new RSA(new BigInteger(valueOfN.getText()));
        valueOfP.setText(rsa.getPrimes().value1.toString());
        valueOfQ.setText(rsa.getPrimes().value2.toString());
        valueOfE.setText(rsa.getE().toString());
        valueOfD.setText(rsa.getD().toString());
        valueOfPHI.setText(rsa.getPhi().toString());
        System.out.println(rsa.toString());
    }

    @FXML
    private void calculateE() {
        if (rsa.getN().toString().isEmpty()) {
            addErrorMessage(ERROR_MESSAGE_E);
            return;
        }

        rsa.calculateE();
        valueOfE.setText(rsa.getE().toString());
        valueOfD.setText(rsa.getD().toString());
        System.out.println(rsa.toString());
    }

    @FXML
    private void validateE() {
        if (valueOfE.getText().isEmpty()) {
            addErrorMessage(ERROR_MESSAGE_E);
            return;
        }

        BigInteger e = new BigInteger(valueOfE.getText());
        boolean isValid = rsa.validateE(e);
        if (!isValid) {
            addErrorMessage(ERROR_MESSAGE_E);
        } else {
            errorMessage.setText("");
            rsa.setE(e);
            rsa.calculateD();
            valueOfD.setText(rsa.getD().toString());
        }
        System.out.println(isValid);
    }

    @FXML
    private void encryptMessage() {
        List<BigInteger> list = Encrypt.encryptMessage(valueOfEText.getText(), rsa.getN(), rsa.getE());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.toArray().length; i++){
            if (i == (list.toArray().length - 1)) {
                result.append(list.get(i).toString());
            } else {
                result.append(list.get(i).toString()).append(", ");
            }
        }
        valueOfEEncryptedText.setText(result.toString());
        exampleInput.setText("Example input: " + result.toString());
    }

    @FXML
    private void decryptMessage() {
        List<BigInteger> encryptedMessage = new ArrayList();
        for (String numberAsString : valueOfDEncryptedText.getText().split(", ")) {
            encryptedMessage.add(new BigInteger(numberAsString));
        }
        String decryptedMessage = Decrypt.decryptMessage(encryptedMessage, rsa.getN(), rsa.getD());
        valueOfDDecryptedText.setText(decryptedMessage);
    }


    private void addErrorMessage(String msg) {
        errorMessage.setText(errorMessage.getText() + "\n" + msg);
    }

    private void clearFields() {
        errorMessage.setText("");
        valueOfN.clear();
        valueOfP.clear();
        valueOfQ.clear();
        valueOfE.clear();
        valueOfD.clear();
        valueOfPHI.clear();
        rsa = null;
    }
}
