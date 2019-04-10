package no.hiof.fredrivo.Validation;

import javafx.scene.control.Alert;
import no.hiof.fredrivo.Data.DataHandler;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.controller.Navigation;
import no.hiof.fredrivo.model.Profile;

public class InputValidation {

    private static MainJavaFX mainJavaFX;

    public static void regInputCheck(Profile profile, String repPassword){
        mainJavaFX = MainJavaFX.javaFXApplication;
        //passord: min 8 tegn max 20
        //minst 1 uppercase og ett tall.

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
            return;
        }

        StringBuilder validationMessage = new StringBuilder();
        int count = 0;
        if (! (profile.getName().matches("^[A-Za-z ]*$"))){
            validationMessage.append("Navn kan bare ineholde store og små bokstaver.\n");
            count++;
        }

        //REGEX OG KRAV FOR EMAIL TILLAT AV RFC 5322:
        // ^                                  # Start på string
        // [a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]    # Store og små bokstaver, tall og tegnene _!#$%&’*+/=?`{|}~^.- er lovlige før @
        // +@                                 # @ kreves // forventes i mønsteret
        // [a-zA-Z0-9.-]                      # Store og små bokstaver, tall og tegnene .-
        // +$                                 # Slutt på string
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
            count++;
        }

        if (profile.getEmail().length() > 254 ){
            validationMessage.append("Email kan ikke overstige 254 tegn.");
            count++;
        }




        //REGEX OG KRAV FOR PASSORD:
        //  ^                # Start på string
        // (?=.*[0-9])       # Minst ett tall
        // (?=.*[a-z])       # Minst en liten bokstav
        // (?=.*[A-Z])       # Minst en stor bokstav
        // (?=\S+$)          # Ingen mellomrom
        // .{8,20}           # Minst 8, maks 20 tegn
        // $                 # Slutt på string
        if ( !(profile.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$")) ){
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
            Navigation.goToAlertBox("Feil i navn felt.", message, Alert.AlertType.ERROR);
        }

        //Registrerer brukeren hvis det ikke er noen feil i input.
        else{
            DataHandler.regNewUser(profile);
        }

    }



    private static boolean regInputIsNotEmpty(Profile profile, String repPassword) {
        return profile.getName().isEmpty() || profile.getEmail().isEmpty() || profile.getPassword().isEmpty() || repPassword.isEmpty();

    }

    public static boolean loginInputEmptyCheck(String email, String password){
        return email.isEmpty() || password.isEmpty();
        //TODO: Tekstfeltene i loginpage sjekes om er tomme og så kalles userExistsCheck().
    }

    public static boolean userExistsCheck(String email) {
        //if email exists in users.json
        if (true){
            return true;
        }
        else{
            return false;
        }

        //TODO: hent info fra json i DataHandler og sjekk om email eksisterer.
    }

    private boolean logIn(String email, String password){
        //TODO: Funksjon for å logge inn og sette variabel logget inn til true.
        boolean userExists = InputValidation.userExistsCheck(email); //returnere true/false
        if (userExists){
            return true;
        }
        //TODO: melding hvis det er feil innlogging informasjon.
        else{
            System.out.println("Finner ikke bruker.");
        }

        return false;
    }
}
