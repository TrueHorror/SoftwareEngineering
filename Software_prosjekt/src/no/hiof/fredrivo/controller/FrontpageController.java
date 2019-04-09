package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import no.hiof.fredrivo.MainJavaFX;

import java.io.IOException;

public class FrontpageController {

    private MainJavaFX mainJavaFx;

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

        mainJavaFx = MainJavaFX.javaFXApplication;

        registrerUserPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    mainJavaFx.showRegPage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        loginPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    mainJavaFx.start(mainJavaFx.getPrimaryStage());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        userProfilePageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    mainJavaFx.showProfilePage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        eventsPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    mainJavaFx.showEventsPage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }




}
