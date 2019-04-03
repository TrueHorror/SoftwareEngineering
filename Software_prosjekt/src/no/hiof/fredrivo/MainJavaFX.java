package no.hiof.fredrivo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJavaFX extends Application {
    public static MainJavaFX javaFXApplikasjon;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public MainJavaFX(){
        MainJavaFX.javaFXApplikasjon = this;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        FXMLLoader fxmlInnlaster = new FXMLLoader();

        fxmlInnlaster.setLocation(getClass().getResource("view/forside.fxml"));
        Parent rootNode = fxmlInnlaster.load();

        Scene hovedScene = new Scene(rootNode);

        primaryStage.setTitle("Super Arrangement");
        primaryStage.setScene(hovedScene);
        primaryStage.show();
    }
}
