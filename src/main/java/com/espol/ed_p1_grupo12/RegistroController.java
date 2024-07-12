package com.espol.ed_p1_grupo12;

import Modelo.User;
import static Modelo.Writer.escribirUsuarios;
import static com.espol.ed_p1_grupo12.LoginController.usuariosRegistrados;
import java.io.IOException;
import java.net.URL;
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
    @FXML
    private VBox vbox_field3_registro;
    @FXML
    private VBox vbox_field4_registro;
    @FXML
    private VBox vbox_field5_registro;
    @FXML
    private TextField text_nombre_registro;
    @FXML
    private TextField text_apellido_registro;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToInicio () throws IOException {
        App.setRoot("Inicio");
    }
    
    @FXML
    private void switchToInicioRegister() throws IOException{ //Se supone que regresa pero se registra el usuario y se logea
        usuariosRegistrados = User.objetoUsuarios(App.pathArchivo + "usuarios.txt");
        String correo = text_correo_registro.getText();
        String contraseña = text_contra_registro.getText();
        String nombre=text_nombre_registro.getText();
        String apellido=text_apellido_registro.getText();
        boolean repetido=User.reconocerUsuarios(correo,usuariosRegistrados);
        
        if(correo!=null && contraseña!=null && !repetido){
            // Registrar nuevo usuario
            User nuevoUsuario = new User(correo, contraseña,nombre,apellido);
            usuariosRegistrados.add(nuevoUsuario);
            // Escribir usuarios actualizados en el archivo
            escribirUsuarios(usuariosRegistrados, App.pathArchivo + "usuarios.txt");
            //-----
            
            System.out.println("Se ha registrado Correctamente");
            App.setRoot("Inicio");
        }else{
            System.out.println("Usuario o contraseña invalido");
            text_correo_registro.clear();
            text_contra_registro.clear();
            
        }
        
    }
  
}
