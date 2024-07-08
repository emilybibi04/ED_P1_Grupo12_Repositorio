package com.espol.ed_p1_grupo12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RegistroController implements Initializable {

    @FXML
    Button boton_regreso;
    @FXML
    private HBox fondo_registro;
    @FXML
    private VBox vbox_izq_registro;
    @FXML
    private VBox vbox_der_registro;
    @FXML
    private Label correo_label_registro;
    @FXML
    private VBox vbox_field1_registro;
    @FXML
    private TextField text_correo_registro;
    @FXML
    private VBox vbox_field2_registro;
    @FXML
    private PasswordField text_contra_registro;
    @FXML
    private Button boton_registro;
    @FXML
    private Label status;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToInicio () throws IOException {
        App.setRoot("Inicio");
    }
  
}
