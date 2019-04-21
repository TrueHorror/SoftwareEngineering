import no.hiof.fredrivo.Validation.InputValidation;
import no.hiof.fredrivo.model.Profile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInputs {

    @Test
    public void testLoginInputEmptyCheckIsEmpty(){
        assertTrue(InputValidation.loginInputEmptyCheck("",""));
    }

    @Test
    public void testLoginInputEmptyCheckIsNotEmpty(){
        assertFalse(InputValidation.loginInputEmptyCheck("fghj","asd"));
    }

    @Test
    public void testRegInputCheckReturnsTrueIfInputsIsValid(){
        //REGEX OG KRAV FOR EMAIL TILLAT AV RFC 5322:
        // [a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]    # Store og små bokstaver, tall og tegnene _!#$%&’*+/=?`{|}~^.- er lovlige før @
        // +@                                 # @ kreves // forventes i mønsteret
        // [a-zA-Z0-9.-]                      # Store og små bokstaver, tall og tegnene .-
        // +\.[a-zA-Z]{2,4}                   # Email må slutte med . etterfulgt av store eller små bokstaver av lengde 2 til 4
        //
        //  Email kan ikke inneholde mer en 254 tegn.

        //REGEX OG KRAV FOR PASSORD:
        // (?=.*[0-9])       # Minst ett tall
        // (?=.*[a-z])       # Minst en liten bokstav
        // (?=.*[A-Z])       # Minst en stor bokstav
        // (?=\S+$)          # Ingen mellomrom
        // .{8,20}           # Minst 8, maks 20 tegn

        //REGEX OG KRAV FOR NAVN:
        //^[A-Za-z ]*$                        # Store og små bokstaver og mellomrom er tillat

        //Passord i objektet og repPassword må være like.
        assertTrue(InputValidation.regInputCheck(new Profile("Fredrik@email.com","Apekatt123", "Fredrik"), "Apekatt123"));
    }

    @Test
    public void testUserExistsCheckReturnsTrueIfUserExistsInJsonFile(){
        //Email må finnes i Json filen users.json
        //fredrik@gmail.com finnes allerde i filen derfor skal det returneres trur med denne emailen
        assertTrue(InputValidation.userExistsCheck("fredrik@gmail.com"));
    }

    @Test
    void testUserExistsCheckReturnsFalseIfUserDoNotExistInJsonFile(){
        //Denne emailen finnes ikke i json filen users.json
        assertFalse(InputValidation.userExistsCheck("finnesikke@gmail.com"));
    }


}
