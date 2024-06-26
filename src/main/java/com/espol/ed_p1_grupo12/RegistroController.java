package com.espol.ed_p1_grupo12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RegistroController implements Initializable {

    @FXML
    Button boton_regreso;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToInicio () throws IOException {
        App.setRoot("Inicio");
    }
}
