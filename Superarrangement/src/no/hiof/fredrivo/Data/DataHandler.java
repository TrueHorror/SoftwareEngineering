package no.hiof.fredrivo.Data;

import com.google.gson.Gson;
import no.hiof.fredrivo.model.Profile;

import java.io.*;
import java.util.ArrayList;


public class DataHandler {
    private static ArrayList<Profile> profileArrayList;

    public static void regNewUser(Profile profile) {
        writeToJson(profile, "users.json");
    }

    public static void readFromJson(String fileName){
        try {
            profileArrayList = new ArrayList<>();
            Gson gson = new Gson();

            BufferedReader b = new BufferedReader(new FileReader(fileName));
            //TODO: Virker dette? Finn ut en smart løsning på å lagre objektene i liste som kan søkes i senere (fine om email eksisterer.)
            profileArrayList.add(gson.fromJson(b, Profile.class));
            System.out.println(profileArrayList);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeToJson(Profile profile, String filename){
        try {
            Gson gson = new Gson();

            String jsonString = gson.toJson(profile);

            FileWriter fileWriter = new FileWriter(filename);

            fileWriter.write(jsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
