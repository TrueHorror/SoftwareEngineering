package no.hiof.fredrivo.controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import no.hiof.fredrivo.Data.DataHandler;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.model.Events;

import java.io.IOException;
import java.util.ArrayList;


public class EventsController extends SuperController {
    @FXML
    public ListView eventsListView;

    @FXML
    public Button addToCartButton,
                  goToCheckOutButton;
    public TextArea descriptionTextArea;
    public Label pricePerTicketLabel;
    public Label ticketsTotalLabel;
    public Label ticketsLeftLabel;
    public Text pricePerTicketText;
    public Text ticketsTotalText;
    public Text ticketsLeftText;

    private ObservableList<Events> eventsObservableList;
    private Events events;
    private ArrayList<Events> cart;
    private int ticketsLeft;

    private MainJavaFX mainJavaFX;

    @Override
    public void initialize() {
        super.initialize();
        mainJavaFX = MainJavaFX.javaFXApplication;

        cart = new ArrayList<>();

        eventsObservableList = FXCollections.observableArrayList(DataHandler.readEventsFromJson("events.json"));
        eventsListView.setItems(eventsObservableList);

        eventsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Events>() {
            @Override
            public void changed(ObservableValue<? extends Events> observableValue, Events oldEvent, Events newEvent) {
                events = newEvent;
                updateEventsInfo(newEvent);

            }
        });

        addToCartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (events != null){
                    ticketsLeft = events.getTicketsLeft();
                    ticketsLeft--;
                    events.setTicketsLeft(ticketsLeft);
                    cart.add(events);

                }
            }
        });

        goToCheckOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    mainJavaFX.showCheckOut(cart);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }

    private void updateEventsInfo(Events event) {

        if (event != null) {
            descriptionTextArea.setText(event.getEventDescription());
            pricePerTicketLabel.setText("Pris:");
            ticketsTotalLabel.setText("Antall biletter totalt:");
            ticketsLeftLabel.setText("Antall biletter igjen:");
            pricePerTicketText.setText(event.getPrice() + "kr");
            ticketsTotalText.setText(String.valueOf(event.getTotalTickets()));
            ticketsLeftText.setText(String.valueOf(event.getTicketsLeft()));

        }
    }
}
