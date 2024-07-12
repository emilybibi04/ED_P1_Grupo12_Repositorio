/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.ed_p1_grupo12;

import Modelo.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
}
