package no.hiof.fredrivo.model;

import java.util.ArrayList;

public class Profile {
    private String email;
    private String password;
    private String name;
    private ArrayList<Events> atendingEvents;

    public Profile(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Events> getAtendingEvents() {
        return atendingEvents;
    }

    public void setAtendingEvents(ArrayList<Events> atendingEvents) {
        this.atendingEvents = atendingEvents;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
