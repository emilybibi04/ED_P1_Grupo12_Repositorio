package com.espol.ed_p1_grupo12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MisVehiculosController implements Initializable {

    @FXML TextField anio_text_V;
    @FXML TextField precio_text_V;
    @FXML TextField kilo_text_V;
    @FXML TextField motor_text_V;
    @FXML TextField tran_text_V;
    @FXML TextField ubi_text_V;
    @FXML ComboBox cmb_carros_V;
    @FXML HBox fotos_panel;
    @FXML Label lbl_carro1;
    @FXML Label lbl_carro2;
    @FXML Label lbl_propietario;
    @FXML HBox panel_der;
    @FXML HBox panel_izq;
    @FXML Label lbl_pro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    private void switchToMenu () throws IOException {
        App.setRoot("Menu");
    }
    
}
