package no.hiof.fredrivo.Data;

import no.hiof.fredrivo.model.Events;
import no.hiof.fredrivo.model.Profile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Receipt {
    public static void createReceipt(ArrayList<Events> events, Profile profile) throws IOException {
        LocalDateTime timeNow = LocalDateTime.now();

        File file = new File("kvittering-"  + profile.getName() + "-" + timeNow.format(DateTimeFormatter.ofPattern("yyyy-mm-dd-hh-mm")) + ".txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Events e: events) {
            bw.append(e.getEventName() + ": " + e.getPrice() + "\n");
        }
        bw.append("\nSendt til:" + profile.getEmail());
        bw.close();



    }
}