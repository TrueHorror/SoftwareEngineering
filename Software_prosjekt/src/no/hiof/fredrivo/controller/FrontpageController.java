package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.Validation.InputValidation;

public class FrontpageController extends SuperController {

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
                boolean emptyInput = InputValidation.loginInputCheck(emailTextfield.getText(), passwordField.getText());

                if (emptyInput){

                }
                else {
                    Navigation.logIn(emailTextfield.getText(), passwordField.getText());

                }
            }
        });

    }





}
