package no.hiof.fredrivo.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import no.hiof.fredrivo.Data.DataHandler;
import no.hiof.fredrivo.model.Profile;

public class ProfileController extends SuperController{
    @FXML
    public Text profileNameText,
                profileEmailText,
                profileEventsText;



    public void initialize() {
        super.initialize();


        Profile loggedInProfile = DataHandler.getLoggedInProfile();

        profileEmailText.setText(loggedInProfile.getEmail());
        profileNameText.setText(loggedInProfile.getName());
        profileEventsText.setText(loggedInProfile.getAtendingEvents()==null?"Ingen kommende Arrangementer": loggedInProfile.getAtendingEvents().toString());




    }
}
