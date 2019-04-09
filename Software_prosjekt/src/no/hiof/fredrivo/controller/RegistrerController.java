package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.model.InputValidation;
import no.hiof.fredrivo.model.Profile;

import java.io.IOException;


public class RegistrerController {

    private MainJavaFX mainJavaFX;
    private boolean logedIn = false;

    @FXML
    private TextField regUserNameTextfield,
                      regUserEmailTextfield,
                      regUserPasswordTextfield,
                      regUserRepeatPasswordTextfield;
    @FXML
    public Button regUserRegistrerButton,
                  loginPageButton,
                  eventsPageButton,
                  userProfilePageButton,
                  registrerUserPageButton;

    @FXML
    private void initialize(){

        mainJavaFX = MainJavaFX.javaFXApplication;

        loginPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToStart();
            }
        });

        userProfilePageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToProfile();
            }
        });

        eventsPageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToEvents();
            }
        });

    }


    public void registerUser(ActionEvent actionEvent) {

        String name = regUserNameTextfield.getText();
        String email = regUserEmailTextfield.getText();
        String repPassword = regUserRepeatPasswordTextfield.getText();
        String password = regUserPasswordTextfield.getText();

        //TODO feilmelding på valideringer, ikke sysOut.
        if ( name.isEmpty()) {
            System.out.println("Fyll i navn.");
        }
        if (email.isEmpty()) {
            System.out.println("Fyll i Email.");
        }
        if (password.isEmpty()) {
            System.out.println("Fyll i Passord.");
        }
        if (password != repPassword) {
            System.out.println("Passordene må være lik.");
        }


        Profile profile = new Profile(email, password, name);

        InputValidation.inputCheck(profile, repPassword);




    }

    public void goToStart() {
        try {
            mainJavaFX.start(mainJavaFX.getPrimaryStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToEvents() {
        try {
            mainJavaFX.showEventsPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToProfile() {
        try {
            //TODO: Sjekk om det finnes en innlogging.
            if (logedIn) {
                System.out.println("Du må være innlogget for å åpne profilsiden");
            }
            else {
                mainJavaFX.showProfilePage();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
