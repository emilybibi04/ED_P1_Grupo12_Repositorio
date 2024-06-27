package com.espol.ed_p1_grupo12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginController implements Initializable {
    
    @FXML
    Button boton_regreso_l;
    @FXML
    private HBox fondo_login;
    @FXML
    private VBox vbox_izq_login;
    @FXML
    private VBox vbox_der_login;
    @FXML
    private Label correo_label_login;
    @FXML
    private VBox vbox_field1_login;
    @FXML
    private TextField text_correo_login;
    @FXML
    private VBox vbox_field2_login;
    @FXML
    private TextField text_contra_login;
    @FXML
    private Button boton_login;
    @FXML
    private Label status;
    
    private ServicioUsuario usuario = new ServicioUsuario();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToInicioL () throws IOException {
        App.setRoot("Inicio");
    }
    @FXML
    private void onLoginButtonClick() throws IOException {
        String email = text_correo_login.getText();
        String password = text_contra_login.getText();

        if (usuario.verificar(email, password)) {
            App.setRoot("Menu");
        } else {
            status.setText("Email o contraseña incorrectas.");
        }
        System.out.println("Funciona");
    }

    
    
    
}
