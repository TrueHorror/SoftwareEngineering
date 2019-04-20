package no.hiof.fredrivo.Data;

import no.hiof.fredrivo.model.Events;
import no.hiof.fredrivo.model.Profile;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Receipt {
    public static void createReceipt(ArrayList<Events> events, Profile profile) throws IOException {

        FileWriter writer = new FileWriter("kvittering-"  + profile.getName() + LocalDate.now() + ".txt");
        for (Events e: events) {
            writer.append(e.getEventName() + ": " + e.getPrice() + "\n");
        }
        writer.append("\nSendt til:" + profile.getEmail());



    }
}