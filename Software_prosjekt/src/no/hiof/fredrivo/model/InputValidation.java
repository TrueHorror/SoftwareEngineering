package no.hiof.fredrivo.model;

public class InputValidation {

    public static void inputCheck(Profile profile, String repPassword){

        //passord: min 8 tegn max 20
        //minst 1 uppercase og ett tall.

        //TODO: skrive feilmelding, ikke sysout

        if (profile == null) {
            System.out.println("Fyll i tekstfeltene");
        }

        //Hvis navnet bare inneholder små eller store bokstaver
        if (! (profile.getName().matches("[^A-Za-z ]"))){
            System.out.println("Navn kan bare ineholde store og små bokstaver");
        }
        //TODO: Få hjelp av Ingrid å løse passord
        if (! (profile.getPassword().matches("[^A-Za-z ]"))){
            System.out.println("Navn kan bare ineholde store og små bokstaver");
        }

        if (profile.getPassword() != repPassword) {
            System.out.println("Passordene må være lik.");
        }






    }
}
