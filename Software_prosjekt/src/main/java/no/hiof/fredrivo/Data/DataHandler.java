package no.hiof.fredrivo.Data;

import com.google.gson.Gson;
import no.hiof.fredrivo.model.Profile;

import java.io.*;


public class DataHandler {

    public static void regNewUser(Profile profile) {
        writeToJson(profile, "users.json");
    }

    public static void readFromJson(String fileName){
        try {
            Gson gson = new Gson();

            BufferedReader b = new BufferedReader(new FileReader(fileName));

            gson.fromJson(b, Profile.class);



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
