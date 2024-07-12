package com.espol.ed_p1_grupo12;

import Modelo.Seccion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        App.cliente = Seccion.getLogged();
        String nom = App.cliente.getNombre();
        String ap = App.cliente.getApellido();
        String correo = App.cliente.getEmail();
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
    
    @FXML
    private void cambiarNombre() throws IOException {
        VBox detalle = new VBox();
        HBox uno = new HBox();
        HBox dos = new HBox();
        
        Label lb1 = new Label("Cambiar Nombre");
        Label lb2 = new Label("Nombre: ");
        Label lb3 = new Label("Apellido: ");
        Button bt1 = new Button ("Aceptar");
        Button bt2 = new Button ("Cancelar");
        
        TextField tx1 = new TextField();
        TextField tx2 = new TextField();
        
        tx1.setText(App.cliente.getNombre());
        tx2.setText(App.cliente.getApellido());
        
        bt1.setOnMouseClicked(e -> {
            Stage s = (Stage) bt1.getScene().getWindow();
            s.close();
            try {
                App.cliente.setNombre(tx1.getText());
                App.cliente.setApellido(tx2.getText());
                App.setRoot("Ajustes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        bt2.setOnMouseClicked(e -> {
            Stage s = (Stage) bt2.getScene().getWindow();
            s.close();
            try {
                App.setRoot("Ajustes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        uno.getChildren().addAll(lb2, tx1);
        dos.getChildren().addAll(lb3, tx2);
        detalle.getChildren().addAll(lb1, uno, dos, bt1, bt2);
        
        Scene s = new Scene(detalle, 420, 250);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Cambiar Nombre");
        stage.show();
    }
    
    @FXML
    private void cambiarCorreo() throws IOException {
        VBox detalle = new VBox();
        HBox uno = new HBox();
        
        Label lb1 = new Label("Cambiar Correo");
        Label lb2 = new Label("Correo: ");
        Button bt1 = new Button ("Aceptar");
        Button bt2 = new Button ("Cancelar");
        
        TextField tx1 = new TextField();
        
        tx1.setText(App.cliente.getEmail());
        
        bt1.setOnMouseClicked(e -> {
            Stage s = (Stage) bt1.getScene().getWindow();
            s.close();
            try {
                App.cliente.setEmail(tx1.getText());
                App.setRoot("Ajustes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        bt2.setOnMouseClicked(e -> {
            Stage s = (Stage) bt2.getScene().getWindow();
            s.close();
            try {
                App.setRoot("Ajustes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        uno.getChildren().addAll(lb2, tx1);
        detalle.getChildren().addAll(lb1, uno, bt1, bt2);
        
        Scene s = new Scene(detalle, 420, 250);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Cambiar Nombre");
        stage.show();
    }
    
    @FXML
    private void cambiarContra() throws IOException {
        VBox detalle = new VBox();
        HBox uno = new HBox();
        HBox dos = new HBox();
        
        Label lb1 = new Label("Cambiar Contraseña");
        Label lb2 = new Label("Contraseña actual: ");
        Label lb3 = new Label("Contraseña nueva: ");
        Button bt1 = new Button ("Aceptar");
        Button bt2 = new Button ("Cancelar");
        
        TextField tx1 = new TextField();
        TextField tx2 = new TextField();
        
        bt1.setOnMouseClicked(e -> {
            Stage s = (Stage) bt1.getScene().getWindow();
            s.close();
            try {
                App.cliente.setEmail(tx2.getText());
                App.setRoot("Ajustes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        bt2.setOnMouseClicked(e -> {
            Stage s = (Stage) bt2.getScene().getWindow();
            s.close();
            try {
                App.setRoot("Ajustes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        uno.getChildren().addAll(lb2, tx1);
        dos.getChildren().addAll(lb3, tx2);
        detalle.getChildren().addAll(lb1, uno, dos, bt1, bt2);
        
        Scene s = new Scene(detalle, 420, 250);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Cambiar Contraseña");
        stage.show();
    }
    
}
