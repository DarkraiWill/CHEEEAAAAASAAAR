package com.example.cheaaaaaazaaaar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController extends cheas {
    @FXML
    private Label welcomeText;
    @FXML
    private Label questionText;
    @FXML
    private TextField answerField;
    @FXML
    private Button baton;
    private int buttonClickCount = 0;
    private String filePath;
    private int shiftKey;
    @FXML
    protected void onHelloButtonClick() {
        buttonClickCount++;
        switch (buttonClickCount) {
            case 1:
                baton.setText("Продолжить");
                answerField.setVisible(true);
                questionText.setText("Enter the file path: ");
                break;
            case 2:
                filePath = answerField.getText();
                answerField.clear();
                questionText.setText("Enter the shift key (1-25): ");
                break;
            case 3:
                shiftKey = getValidShiftKey(Integer.parseInt(answerField.getText()));
                answerField.clear();
                questionText.setText("Enter 'e' to encrypt or 'd' to decrypt: ");
                break;
            case 4:
                String operation = answerField.getText();
                answerField.clear();
                if (operation.equalsIgnoreCase("e")) {
                    encryptFile(filePath, shiftKey);
                    questionText.setText("Готово");
                    answerField.setVisible(false);
                } else if (operation.equalsIgnoreCase("d")) {
                    decryptFile(filePath, shiftKey);
                    questionText.setText("Готово");
                    answerField.setVisible(false);

                } else {
                    welcomeText.setText("Invalid operation. Please try again.");
                }
                buttonClickCount = 0; // Reset the click count
                break;
            default:
                break;
        }
    }
}
