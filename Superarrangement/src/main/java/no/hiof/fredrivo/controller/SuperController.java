package no.hiof.fredrivo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.model.Profile;

public abstract class SuperController {

    @FXML
    public Button loginPageButton,
                  eventsPageButton,
                  userProfilePageButton,
                  registrerUserPageButton;

    private MainJavaFX mainJavaFX;

    public void initialize(){
        mainJavaFX = MainJavaFX.javaFXApplication;

        registrerUserPageButton.setOnAction(Navigation.goToRegHandler);

        loginPageButton.setOnAction(Navigation.goToLoginHandler);

        userProfilePageButton.setOnAction(Navigation.goToProfileHandler);

        eventsPageButton.setOnAction(Navigation.goToEventsHandler);

    }

}
