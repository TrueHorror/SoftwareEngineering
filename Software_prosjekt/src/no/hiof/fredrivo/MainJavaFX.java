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

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("view/registrerUser.fxml"));
        Parent rootNode = loader.load();

        Scene hovedScene = new Scene(rootNode);

        primaryStage.setTitle("Registrering");
        primaryStage.setScene(hovedScene);
        primaryStage.show();

    }

    //TODO fikse view til Events og Profile
    public void showEventsPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("view/registrerUser.fxml"));
        Parent rootNode = loader.load();

        Scene hovedScene = new Scene(rootNode);

        primaryStage.setTitle("Registrering");
        primaryStage.setScene(hovedScene);
        primaryStage.show();
    }

    public void showProfilePage() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("view/registrerUser.fxml"));
        Parent rootNode = loader.load();

        Scene hovedScene = new Scene(rootNode);

        primaryStage.setTitle("Registrering");
        primaryStage.setScene(hovedScene);
        primaryStage.show();
    }

}
