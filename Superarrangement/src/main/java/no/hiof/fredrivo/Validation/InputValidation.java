package no.hiof.fredrivo.Validation;

import javafx.scene.control.Alert;
import no.hiof.fredrivo.Data.DataHandler;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.controller.Navigation;
import no.hiof.fredrivo.model.Profile;

import java.util.ArrayList;

public class InputValidation {
    private static ArrayList<Profile> profilesArrayListForCheckingExistingEmail;

    private static MainJavaFX mainJavaFX;

    public static boolean regInputCheck(Profile profile, String repPassword){
        mainJavaFX = MainJavaFX.javaFXApplication;

        StringBuilder emptyValuesMessage = new StringBuilder();
        if (regInputIsNotEmpty(profile, repPassword)) {

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

            Navigation.goToAlertBox("Noen felt er ikke fylt i", emptyValuesMessage.toString(), Alert.AlertType.ERROR);

        }

        StringBuilder validationMessage = new StringBuilder();
        int inputErrors = 0;

        //REGEX OG KRAV FOR NAVN:
        //^[A-Za-z ]*$                        # Store og små bokstaver og mellomrom er tillat
        if (! (profile.getName().matches("^[A-Za-z ]*$"))){
            validationMessage.append("Navn kan bare ineholde store og små bokstaver.\n");
            inputErrors++;
        }

        //REGEX OG KRAV FOR EMAIL TILLAT AV RFC 5322:
        // [a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]    # Store og små bokstaver, tall og tegnene _!#$%&’*+/=?`{|}~^.- er lovlige før @
        // +@                                 # @ kreves // forventes i mønsteret
        // [a-zA-Z0-9.-]                      # Store og små bokstaver, tall og tegnene .-
        // +\.[a-zA-Z]{2,4}                   # Email må slutte med . etterfulgt av store eller små bokstaver av lengde 2 til 4
        //
        //  Email kan ikke inneholde mer en 254 tegn.
        if ( !(profile.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) ) {
            validationMessage.append("\nFør @ er bare:\n" +
                    "Store og små bokstaver,\n" +
                    "tall,\n" +
                    "Og tegnene: _!#$%&’*+/=?`{|}~^.- tilatte.\n" +
                    "Etter @:\n" +
                    "Store og små bokstaver,\n" +
                    "tall og tegnene .-\n");
            inputErrors++;
        }

        if (profile.getEmail().length() > 254 ){
            validationMessage.append("Email kan ikke overstige 254 tegn.");
            inputErrors++;
        }




        //REGEX OG KRAV FOR PASSORD:
        // (?=.*[0-9])       # Minst ett tall
        // (?=.*[a-z])       # Minst en liten bokstav
        // (?=.*[A-Z])       # Minst en stor bokstav
        // (?=\S+$)          # Ingen mellomrom
        // .{8,20}           # Minst 8, maks 20 tegn
        if ( !(profile.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$")) ){
            validationMessage.append("\nPassordene må inneholde:\n" +
                                    "Minst en stor bokstav.\n" +
                                    "Minst en liten bokstav.\n" +
                                    "Minst ett tall.\n" +
                                    "Ingen mellomrom.\n" +
                                    "Minst 8 tegn.\n");
            inputErrors++;
        }

        if (!profile.getPassword().equals(repPassword)) {
            validationMessage.append("\nPassordene må matche.");
            inputErrors++;
        }

        if(inputErrors > 0) {
            String message = validationMessage.toString();
            Navigation.goToAlertBox("Feil i navn felt.", message, Alert.AlertType.ERROR);
            return false;
        }

        //Registrerer brukeren hvis det ikke er noen feil i input.
        else{


            return true;
        }


    }



    public static boolean regInputIsNotEmpty(Profile profile, String repPassword) {
        return profile.getName().isEmpty() || profile.getEmail().isEmpty() || profile.getPassword().isEmpty() || repPassword.isEmpty();

    }

    public static boolean loginInputEmptyCheck(String email, String password){
        if (email.isEmpty() || password.isEmpty()){
            return true;
        }
        return false;

    }

    public static boolean userExistsCheck(String email) {
        //TODO: if email exists in users.json
        profilesArrayListForCheckingExistingEmail = DataHandler.readUsersFromJson("users.json");

        if (profilesArrayListForCheckingExistingEmail.isEmpty())
            return false;
        else {
            for (Profile p: profilesArrayListForCheckingExistingEmail) {
                if (email.equals(p.getEmail())){
                    return true;
                }
            }

        }


        return false;
    }



}
