package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import no.hiof.fredrivo.model.InputValidation;
import no.hiof.fredrivo.model.Profile;


public class RegistrerController {


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

        InputValidation.inputCheck(profile);




    }
}
