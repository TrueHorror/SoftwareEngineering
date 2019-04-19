package no.hiof.fredrivo.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import no.hiof.fredrivo.model.Profile;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class DataHandler {


    public static void regNewUser(Profile profile) {
        String jsonFile = "src\\no\\hiof\\fredrivo\\Data\\users.json";
        writeToJson(profile, jsonFile);
    }

    public static ArrayList<Profile> readFromJson(String fileName){
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            ArrayList<Profile> profileArrayList = new ArrayList<>();
            Profile[] profiles = gson.fromJson(br, Profile[].class);

            if (profiles == null) {
                System.out.println(profiles);
            }
            else {
                for (Profile p: profiles) {
                    profileArrayList.add(p);
                }
            }

            //TODO: Virker dette? Finn ut en smart løsning på å lagre objektene i liste som kan søkes i senere (fine om email eksisterer.)
            System.out.println(profileArrayList);
            //profileArrayList.add(gson.fromJson(b, Profile.class));
            //System.out.println(profileArrayList);

            return profileArrayList;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeToJson(Profile profile, String jsonFile){
        try {

            GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            FileWriter fileWriter = new FileWriter(jsonFile);

            String jsonString = gson.toJson(profile);

            if (readFromJson(jsonFile).isEmpty()) {

                fileWriter.write(jsonString);
                fileWriter.close();
            }
            else {
                String lineToBeAdded;
                for (Profile p: readFromJson(jsonFile)) {
                    lineToBeAdded += gson.toJson();
                }

                fileWriter.write(readFromJson(jsonFile) + jsonString);
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}