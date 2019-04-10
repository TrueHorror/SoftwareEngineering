package no.hiof.fredrivo.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.Validation.InputValidation;
import no.hiof.fredrivo.model.Profile;


public class RegistrerController extends SuperController {

    private MainJavaFX mainJavaFX;
    private boolean inputOk;

    @FXML
    private TextField regUserNameTextfield,
                      regUserEmailTextfield,
                      regUserPasswordTextfield,
                      regUserRepeatPasswordTextfield;
    @FXML
    public Button regUserRegistrerButton;

    public void initialize(){
        super.initialize();

        regUserRegistrerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = regUserNameTextfield.getText();
                String email = regUserEmailTextfield.getText();
                String repPassword = regUserRepeatPasswordTextfield.getText();
                String password = regUserPasswordTextfield.getText();

                Profile profile = new Profile(email, password, name);

                InputValidation.regInputCheck(profile, repPassword);
            }
        });
    }

}
