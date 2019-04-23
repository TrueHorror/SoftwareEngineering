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
    private static Profile newProfile;

    public static void regNewUser(Profile profile) {
        String jsonFile = "users.json";
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
                return new ArrayList<>(Arrays.asList(profiles));

            }

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }



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
                return new ArrayList<>(Arrays.asList(events));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
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

    public static Profile createNewProfile(String email, String password, String name) {
        newProfile = new Profile(email, password, name);
        return newProfile;
    }

    public static Profile getProfile(String email, String password){

        for (Profile p:readUsersFromJson("users.json")) {
            if (p.getEmail().toLowerCase().equals(email.toLowerCase()) && p.getPassword().equals(password)){
                return p;
            }
        }

        return null;
    }

    public static void setNewProfile(Profile newProfile) {
        DataHandler.newProfile = newProfile;
    }

    public static Profile getNewProfile() {
        return newProfile;
    }
}