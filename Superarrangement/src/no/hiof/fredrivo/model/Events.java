package no.hiof.fredrivo.model;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Events {
    private String eventName;
    private int totalTickets;
    private int ticketsLeft;
    private LocalDate eventTime;
    private Image eventImg;
    private String eventDescription;
    private int id;



    public Events(String eventName, int totalTickets, int ticketsLeft, LocalDate eventTime, Image eventImg, String eventDescription) {
        this.eventName = eventName;
        this.totalTickets = totalTickets;
        this.ticketsLeft = ticketsLeft;
        this.eventTime = eventTime;
        this.eventImg = eventImg;
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

    public LocalDate getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDate eventTime) {
        this.eventTime = eventTime;
    }

    public Image getEventImg() {
        return eventImg;
    }

    public void setEventImg(Image eventImg) {
        this.eventImg = eventImg;
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
}
