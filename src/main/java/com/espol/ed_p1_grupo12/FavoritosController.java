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

public class FavoritosController implements Initializable {

    @FXML TextField anio_text_F;
    @FXML TextField precio_text_F;
    @FXML TextField kilo_text_F;
    @FXML TextField motor_text_F;
    @FXML TextField tran_text_F;
    @FXML TextField ubi_text_F;
    @FXML ComboBox cmb_carros_F;
    @FXML HBox fotos_panel;
    @FXML Label lbl_carro1;
    @FXML Label lbl_carro2;
    @FXML Label lbl_propietario;
    @FXML HBox panel_der;
    @FXML HBox panel_izq;
    @FXML Label lbl_pro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToMenu () throws IOException {
        App.setRoot("Menu");
    }
    
}
