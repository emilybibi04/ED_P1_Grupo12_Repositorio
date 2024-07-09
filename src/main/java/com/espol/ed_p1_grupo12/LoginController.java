package com.espol.ed_p1_grupo12;

import static Modelo.Readable.leerArchivo;
import Modelo.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginController implements Initializable {
    
    @FXML
    Button boton_regreso_l;

    @FXML
    private TextField text_correo_login;

    @FXML
    private PasswordField text_contra_login;
    
    @FXML
    private Button boton_login;
    
    @FXML
    private Label status;
    
    static ArrayList<User> usuariosRegistrados = new ArrayList<>();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToInicioL () throws IOException {
        App.setRoot("Inicio");
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        usuariosRegistrados = User.objetoUsuarios(App.pathArchivo + "usuarios.txt");
        String correo = text_correo_login.getText();
        String pass = text_contra_login.getText();
        
        boolean validar = User.verificar(correo, pass, usuariosRegistrados);
        if(validar){
            App.cliente = User.crearUsuario(correo, pass, usuariosRegistrados);
            App.setRoot("Menu");
        }
        else {
            status.setText("Correo o Contraseña Incorrecta");
            text_correo_login.clear();
            text_contra_login.clear();
        }
    }

    
    
    
}
