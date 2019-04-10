package no.hiof.fredrivo.controller;

import javafx.scene.control.Alert;
import no.hiof.fredrivo.MainJavaFX;

import java.io.IOException;

public class Navigation {

    private static MainJavaFX mainJavaFX = MainJavaFX.javaFXApplication;

    public static void goToLoginPage(){

        try {
            mainJavaFX.start(mainJavaFX.getPrimaryStage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void goToProfile() {

        try {
            //TODO: Sjekk om det finnes en innlogging.
            if (mainJavaFX.isLogedIn()) {
                mainJavaFX.showProfilePage();
            }
            else {
                //TODO: Melding om at bruker må være innlogget.
                mainJavaFX.showAlert("Ingen inlogging", "Du må være innlogget for å åpne profilsiden", Alert.AlertType.INFORMATION);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void goToRegistration(){

        try {
            mainJavaFX.showRegPage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void goToEvents(){

        try {
            mainJavaFX.showEventsPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
