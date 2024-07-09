package com.espol.ed_p1_grupo12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AjustesController implements Initializable {

    @FXML Label lbl_nom;
    @FXML Label lbl_correo;
    @FXML Button boton_nom;
    @FXML Button boton_correo;
    @FXML Button boton_contra;
    @FXML Button boton_regresar;
    @FXML Button boton_cerrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String nom = App.cliente.getNombre();
        String ap = App.cliente.getApellido();
        String correo = App.cliente.getEmail();
//        String pass = App.cliente.getPassword();
        
        lbl_nom.setText(nom + " " + ap);
        lbl_correo.setText(correo);
        
        
    }

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("Menu");
    }
    
    @FXML
    private void swtichToInicio() throws IOException {
        App.setRoot("Inicio");
    }
    
}
