package com.espol.ed_p1_grupo12;

import Modelo.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    
    public static String pathImg = "src/main/resources/Pictures/";
    public static String pathArchivo = "src/main/resources/Files/";
    public static String pathCarros = "src/main/resources/Cars/";
    private static Scene scene;
    public static User cliente;

    
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Inicio"), 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}