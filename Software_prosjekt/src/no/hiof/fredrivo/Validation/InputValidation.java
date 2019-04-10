package no.hiof.fredrivo.Validation;

import javafx.scene.control.Alert;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.controller.RegistrerController;
import no.hiof.fredrivo.model.Profile;

public class InputValidation {

    private static MainJavaFX mainJavaFX;

    public static void regInputCheck(Profile profile, String repPassword){
        mainJavaFX = MainJavaFX.javaFXApplication;
        //passord: min 8 tegn max 20
        //minst 1 uppercase og ett tall.

        StringBuilder emptyValuesMessage = new StringBuilder();
        if (inputIsNotEmpty(profile, repPassword)) {
            if (profile.getName().isEmpty()) {
                emptyValuesMessage.append("Fyll ut navn.\n");
            }
            if (profile.getEmail().isEmpty()) {
                emptyValuesMessage.append("Fyll ut Email.\n");
            }
            if (profile.getPassword().isEmpty()) {
                emptyValuesMessage.append("Fyll ut Passord.\n");
            }
            if (repPassword.isEmpty()) {
                emptyValuesMessage.append("Gjennta passord");
            }

            String message = emptyValuesMessage.toString();

            mainJavaFX.showAlert("Noen felt er ikke fylt i", message , Alert.AlertType.ERROR);
            return;
        }

        StringBuilder validationMessage = new StringBuilder();
        int count = 0;
        if (! (profile.getName().matches("^[A-Za-z ]*$"))){
            validationMessage.append("Navn kan bare ineholde store og små bokstaver.\n");
            count++;
        }

        //REGEX OG KRAV:
        //  ^                # Start på string.
        // (?=.*[0-9])       # Minst ett tall.
        // (?=.*[a-z])       # Minst en liten bokstav.
        // (?=.*[A-Z])       # Minst en stor bokstav.
        // (?=\S+$)          # Ingen mellomrom.
        // .{8,20}           # Minst 8, maks 20 tegn.
        // $                 # Slutt på string.
        if (! (profile.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$"))){
            validationMessage.append("\nPassordene må inneholde:\n" +
                                    "Minst en stor bokstav.\n" +
                                    "Minst en liten bokstav.\n" +
                                    "Minst ett tall.\n" +
                                    "Ingen mellomrom.\n" +
                                    "Minst 8 tegn.\n");
            count++;
        }

        if (!profile.getPassword().equals(repPassword)) {
            validationMessage.append("\nPassordene må matche.");
            count++;
        }

        if(count > 0) {
            String message = validationMessage.toString();
            mainJavaFX.showAlert("Feil i navn felt.", message, Alert.AlertType.ERROR);
        }
        else{
            RegistrerController.regNewUser(profile);
        }





    }

    private static boolean inputIsNotEmpty(Profile profile, String repPassword) {
        if (profile.getName().isEmpty() || profile.getEmail().isEmpty() || profile.getPassword().isEmpty() || repPassword.isEmpty()){
            return true;
        }

        return false;
    }


    public static void loginInputCheck(){
        //TODO: Tekstfeltene i loginpage sjekes om er tomme og så kalles userExistsCheck().
    }

    public static boolean userExistsCheck(String email) {
        //TODO: hent info fra json i ReadAndWriteToJson og sjekk om email eksisterer.
        return true;
    }
}
