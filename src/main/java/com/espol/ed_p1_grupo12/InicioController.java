package com.espol.ed_p1_grupo12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InicioController implements Initializable {

    @FXML
    Button boton_inicio;
    
    @FXML
    Button boton_inicio_registro;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void switchToLogin () throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void switchToRegistro () throws IOException {
        App.setRoot("Registro");
    }  
    
}
