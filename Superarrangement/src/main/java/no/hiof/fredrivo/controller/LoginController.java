package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import no.hiof.fredrivo.Validation.InputValidation;

public class LoginController extends SuperController {


    @FXML
    private Button loginButton;

    @FXML
    private TextField emailTextfield;

    @FXML
    private PasswordField passwordField;


    public void initialize(){

        super.initialize();

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean inputIsEmpty = InputValidation.loginInputEmptyCheck(emailTextfield.getText(), passwordField.getText());

                if (!inputIsEmpty){
                    Navigation.logIn(emailTextfield.getText(), passwordField.getText());
                }
                else {
                    Navigation.goToAlertBox("Tomme tekstfelter.", "Fyll ut Email og Passord.", Alert.AlertType.INFORMATION);
                }
            }
        });

    }





}
