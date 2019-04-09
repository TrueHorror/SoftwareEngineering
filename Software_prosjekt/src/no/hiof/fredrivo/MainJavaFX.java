package no.hiof.fredrivo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainJavaFX extends Application {
    public static MainJavaFX javaFXApplication;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public MainJavaFX(){
        MainJavaFX.javaFXApplication = this;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("view/forside.fxml"));
        Parent rootNode = fxmlLoader.load();

        Scene mainScene = new Scene(rootNode);

        primaryStage.setTitle("Loginn");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public void showRegPage() throws IOException {

        showPage("Registreing", "view/registrerUser.fxml");

    }

    //TODO fikse view til Events og Profile
    public void showEventsPage() throws IOException {
        showPage("Arrangementer" ,"view/events.fxml");
    }

    public void showProfilePage() throws IOException {
        showPage("Profil", "view/profile.fxml");
    }

    private void showPage(String title, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(fxml));
        Parent rootNode = loader.load();

        Scene hovedScene = new Scene(rootNode);

        primaryStage.setTitle(title);
        primaryStage.setScene(hovedScene);
        primaryStage.show();
    }

}
