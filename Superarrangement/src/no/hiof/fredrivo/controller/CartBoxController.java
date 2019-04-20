package no.hiof.fredrivo.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.hiof.fredrivo.Data.DataHandler;
import no.hiof.fredrivo.MainJavaFX;
import no.hiof.fredrivo.model.Events;

import java.util.ArrayList;

public class CartBoxController {

    private Stage stage;

    public ListView itemsInCart;
    public TextField cardNumberTextField;
    public TextField cardThreeDigitCodeTextField;
    public Button payButton;
    public Text priceTotalText;

    private int totalPrice;
    private ObservableList<Events> itemsInCartObservableList;

    public void initialize(){

        payButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.goToAlertBox("Takk for kjøp!", "En kvittering er sendt på Email.", Alert.AlertType.INFORMATION);
                stage.close();
            }
        });

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setCart(ArrayList<Events> cart) {
        itemsInCartObservableList = FXCollections.observableList(cart);
        itemsInCartObservableList = FXCollections.observableArrayList(cart);
        itemsInCart.setItems(itemsInCartObservableList);

        for (Events e: itemsInCartObservableList) {
            totalPrice += e.getPrice();
        }
        String totalPriceText = totalPrice + "kr";
        priceTotalText.setText(totalPriceText);
    }
}
