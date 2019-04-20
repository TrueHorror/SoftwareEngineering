package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import no.hiof.fredrivo.Data.DataHandler;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.Validation.InputValidation;
import no.hiof.fredrivo.model.Profile;

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

    public static void goToProfilePage(){
        try {
            mainJavaFX.showProfilePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EventHandler<ActionEvent> goToEventsHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                if (mainJavaFX.isLogedIn()){
                    mainJavaFX.showEventsPage();
                }
                else {
                    goToAlertBox("Ingen inlogging", "Du må være innlogget for å åpne arrangementsiden", Alert.AlertType.INFORMATION);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public static void goToAlertBox(String title, String message, Alert.AlertType alertType){
        mainJavaFX.showAlert(title, message, alertType);
    }

    public static void logIn(String email, String password){
        Profile p = DataHandler.getProfile(email,password);
        if (p == null){
            Navigation.goToAlertBox("Finner ikke bruker", "Brukeren finnes ikke. Prøv annen email eller passord", Alert.AlertType.INFORMATION);
        }
        else {
            mainJavaFX.setLogedIn(true);
            DataHandler.setLoggedInProfile(p);
            Navigation.goToProfilePage();
        }


    }

}
