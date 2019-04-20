package no.hiof.fredrivo.model;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Events {
    private int price;
    private String eventName;
    private int totalTickets;
    private int ticketsLeft;
    private String eventDescription;
    private int id;



    public Events(int price, String eventName, int totalTickets, int ticketsLeft, String eventDescription) {
        this.price = price;
        this.eventName = eventName;
        this.totalTickets = totalTickets;
        this.ticketsLeft = ticketsLeft;
        this.eventDescription = eventDescription;
        id++;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    public void setTicketsLeft(int ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return eventName;
    }
}
