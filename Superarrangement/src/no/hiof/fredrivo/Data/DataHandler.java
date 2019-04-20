package no.hiof.fredrivo.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import no.hiof.fredrivo.model.Events;
import no.hiof.fredrivo.model.Profile;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class DataHandler {


    private static Profile loggedInProfile;

    public static void regNewUser(Profile profile) {
        String jsonFile = "src\\no\\hiof\\fredrivo\\Data\\users.json";
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(profile);
        writeToJson(profiles, jsonFile);

    }


    public static ArrayList<Profile> readUsersFromJson(String fileName){

        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        Gson gson = gsonBuilder.create();
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Profile[] profiles = gson.fromJson(br, Profile[].class);

            if (profiles == null){
                return new ArrayList<>();

            }
            else {
                ArrayList<Profile> profilesFromJson = new ArrayList<>(Arrays.asList(profiles));
                return profilesFromJson;

            }



            //TODO: Virker dette? Finn ut en smart løsning på å lagre objektene i liste som kan søkes i senere (fine om email eksisterer.)
            //profileArrayList.add(gson.fromJson(b, Profile.class));
            //System.out.println(profileArrayList);




        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Events> readEventsFromJson(String jsonFile) {
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        Gson gson = gsonBuilder.create();
        File file = new File(jsonFile);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Events[] events = gson.fromJson(br, Events[].class);

            if (events == null){
                return new ArrayList<>();

            }
            else {
                ArrayList<Events> eventsFromJson = new ArrayList<>(Arrays.asList(events));
                return eventsFromJson;

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void writeToJson(ArrayList<Profile> profiles, String jsonFile){

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        File file = new File(jsonFile);


        if (readUsersFromJson(jsonFile) == null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                gson.toJson(profiles, bw);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            profiles.addAll(readUsersFromJson(jsonFile));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                gson.toJson(profiles, bw);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }






    }

    public static void setLoggedInProfile(Profile loggedInProfile) {
        DataHandler.loggedInProfile = loggedInProfile;
    }

    public static Profile getLoggedInProfile() {
        return loggedInProfile;
    }


}