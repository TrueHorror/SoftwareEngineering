package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.Validation.InputValidation;

import java.io.IOException;

public class FrontpageController {

    private MainJavaFX mainJavaFX;

    @FXML
    private Button loginPageButton,
                   eventsPageButton,
                   userProfilePageButton,
                   registrerUserPageButton,
                   loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailTextfield;

    public void initialize(){

        mainJavaFX = MainJavaFX.javaFXApplication;

        //"Meny" knapper
        registrerUserPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.goToRegistration();
            }
        });

        loginPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.goToLoginPage();
            }
        });

        userProfilePageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.goToProfile();
            }
        });

        eventsPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.goToEvents();
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String email = emailTextfield.getText();
                String password = passwordField.getText();
                mainJavaFX.setLogedIn(logIn(email, password));
            }
        });

    }

    private boolean logIn(String email, String password){
        //TODO: Funksjon for å logge inn og sette variabel logget inn til true.
        boolean userExists = InputValidation.userExistsCheck(email); //returnere true/false
        if (userExists){
            return true;
        }
        //TODO: melding hvis det er feil innlogging informasjon.
        else{
            System.out.println("Finner ikke bruker.");
        }

        return false;
    }




}
