package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.Validation.InputValidation;

import java.io.IOException;

public class Navigation {

    private static MainJavaFX mainJavaFX = MainJavaFX.javaFXApplication;

    public static EventHandler<ActionEvent> goToLoginHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                mainJavaFX.start(mainJavaFX.getPrimaryStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static EventHandler<ActionEvent> goToRegHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                mainJavaFX.showRegPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public static EventHandler<ActionEvent> goToProfileHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                //TODO: Sjekk om det finnes en innlogging.
                if (mainJavaFX.isLogedIn()) {
                    mainJavaFX.showProfilePage();
                }
                else {
                    //TODO: Melding om at bruker må være innlogget.
                    goToAlertBox("Ingen inlogging", "Du må være innlogget for å åpne profilsiden", Alert.AlertType.INFORMATION);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public static EventHandler<ActionEvent> goToEventsHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                mainJavaFX.showEventsPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public static void goToAlertBox(String title, String message, Alert.AlertType alertType){
        mainJavaFX.showAlert(title, message, alertType);
        //TODO: Extract alle steder der alertbox blir kallt i inputValidation hit.
    }

    public static void logIn(String email, String password){



    }

}
