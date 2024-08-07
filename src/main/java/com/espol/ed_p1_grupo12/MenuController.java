package com.espol.ed_p1_grupo12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuController implements Initializable {
    
    @FXML Button boton_info;
    @FXML Button boton_vehi;
    @FXML Button boton_fav;
    @FXML Button boton_cal;
    @FXML Button boton_ajus;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToVerVehiculo() throws IOException {
        App.setRoot("Informacion");
    }
    
    @FXML
    private void switchToAjustes() throws IOException {
        App.setRoot("Ajustes");
    }
    
    @FXML
    private void switchToMisFav() throws IOException {
        App.setRoot("Favoritos");
    }
    
    @FXML
    private void switchToMisVehiculos() throws IOException {
        App.setRoot("MisVehiculos");
    }
    
    @FXML
    private void switchToCalculadora() throws IOException {
        App.setRoot("Calculadora");
    }
    
}
