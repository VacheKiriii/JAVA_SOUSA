package fr.esiee.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class HelloController {
    @FXML
    private Label l_welcomeText;
    @FXML
    private TextField tf_inputName;
    @FXML

    protected void onHelloButtonClick() {
        if (tf_inputName.getText().isEmpty()) {
            l_welcomeText.setTextFill(Paint.valueOf("red"));
            l_welcomeText.setText("Enter name");
        }
        else {
            l_welcomeText.setTextFill(Paint.valueOf("black"));
            l_welcomeText.setText("Welcome " + tf_inputName.getText() + " !");
            tf_inputName.setText("");
        }
    }
}