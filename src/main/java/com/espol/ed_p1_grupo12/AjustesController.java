package com.espol.ed_p1_grupo12;

import Modelo.Seccion;
import Modelo.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
        detalle.setAlignment(Pos.CENTER);
        HBox uno = new HBox();
        uno.setAlignment(Pos.CENTER);
        HBox dos = new HBox();
        dos.setAlignment(Pos.CENTER);
        HBox tres = new HBox();
        tres.setAlignment(Pos.CENTER);
        tres.setSpacing(25);
        
        AnchorPane es = new AnchorPane();
        es.setPrefHeight(15);
        AnchorPane es2 = new AnchorPane();
        es2.setPrefHeight(8);
        AnchorPane es3 = new AnchorPane();
        es3.setPrefHeight(20);
        
        Label lb1 = new Label("Cambiar Nombre");
        Label lb2 = new Label("Nombre:  ");
        Label lb3 = new Label("Apellido:  ");
        Button bt1 = new Button ("Aceptar");
        Button bt2 = new Button ("Cancelar");
        
        TextField tx1 = new TextField();
        TextField tx2 = new TextField();
        tx1.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 16px");
        tx2.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 16px");
        
        tx1.setText(App.cliente.getNombre());
        tx2.setText(App.cliente.getApellido());
        
        bt1.setOnMouseClicked(e -> {
            Stage s = (Stage) bt1.getScene().getWindow();
            s.close();
            try {
                User usuarioAnterior = new User(App.cliente.getNombre(), App.cliente.getApellido(), App.cliente.getEmail(), App.cliente.getPassword());
                String nuevoNombre = tx1.getText();
                String nuevoApellido = tx2.getText();
                User.actualizarArchivo(App.cliente.getEmail(), App.cliente.getEmail(), App.cliente.getPassword(), nuevoNombre, nuevoApellido);
                App.cliente.setNombre(tx1.getText());
                App.cliente.setApellido(tx2.getText());
                
                InformacionController informacionController = new InformacionController();
                informacionController.actualizarArchivoFavoritos(usuarioAnterior, App.cliente);

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
        
        lb1.setStyle("-fx-font-family: 'Montserrat'; -fx-font-weight: bold; -fx-font-size: 24px; -fx-text-fill: white");
        lb2.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px; -fx-text-fill: white");
        lb3.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px; -fx-text-fill: white");
        bt1.setStyle("-fx-background-color: white; -fx-font-family: 'Montserrat'; -fx-text-fill: #373766; -fx-font-weight: bold; -fx-font-size: 16px");
        bt2.setStyle("-fx-background-color: white; -fx-font-family: 'Montserrat'; -fx-text-fill: #373766; -fx-font-weight: bold; -fx-font-size: 16px");
        detalle.setStyle("-fx-background-color:  #373766;");
        
        uno.getChildren().addAll(lb2, tx1);
        dos.getChildren().addAll(lb3, tx2);
        tres.getChildren().addAll(bt1, bt2);
        detalle.getChildren().addAll(lb1, es, uno, es2, dos, es3, tres);
        
        Scene s = new Scene(detalle, 420, 250);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Cambiar Nombre");
        stage.show();
    }
    
    @FXML
    private void cambiarCorreo() throws IOException {
        VBox detalle = new VBox();
        detalle.setAlignment(Pos.CENTER);
        HBox uno = new HBox();
        uno.setAlignment(Pos.CENTER);
        HBox dos = new HBox();
        dos.setAlignment(Pos.CENTER);
        dos.setSpacing(25);
        
        AnchorPane es = new AnchorPane();
        es.setPrefHeight(15);
        AnchorPane es2 = new AnchorPane();
        es2.setPrefHeight(20);
        
        Label lb1 = new Label("Cambiar Correo");
        Label lb2 = new Label("Correo:  ");
        Button bt1 = new Button ("Aceptar");
        Button bt2 = new Button ("Cancelar");
        
        TextField tx1 = new TextField();
        tx1.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 16px");
        
        tx1.setText(App.cliente.getEmail());
        
        bt1.setOnMouseClicked(e -> {
            Stage s = (Stage) bt1.getScene().getWindow();
            s.close();
            try {
                String nuevoCorreo = tx1.getText();
                User.actualizarArchivo(App.cliente.getEmail(), nuevoCorreo, App.cliente.getPassword(), App.cliente.getNombre(), App.cliente.getApellido());
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
        
        lb1.setStyle("-fx-font-family: 'Montserrat'; -fx-font-weight: bold; -fx-font-size: 24px; -fx-text-fill: white");
        lb2.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px; -fx-text-fill: white");
        bt1.setStyle("-fx-background-color: white; -fx-font-family: 'Montserrat'; -fx-text-fill: #373766; -fx-font-weight: bold; -fx-font-size: 16px");
        bt2.setStyle("-fx-background-color: white; -fx-font-family: 'Montserrat'; -fx-text-fill: #373766; -fx-font-weight: bold; -fx-font-size: 16px");
        detalle.setStyle("-fx-background-color:  #373766;");
        
        uno.getChildren().addAll(lb2, tx1);
        dos.getChildren().addAll(bt1, bt2);
        detalle.getChildren().addAll(lb1, es, uno, es2, dos);
        
        Scene s = new Scene(detalle, 420, 250);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Cambiar Correo Electrónico");
        stage.show();
    }
    
    @FXML
    private void cambiarContra() throws IOException {
        VBox detalle = new VBox();
        detalle.setAlignment(Pos.CENTER);
        HBox uno = new HBox();
        uno.setAlignment(Pos.CENTER);
        HBox dos = new HBox();
        dos.setAlignment(Pos.CENTER);
        HBox tres = new HBox();
        tres.setAlignment(Pos.CENTER);
        tres.setSpacing(25);
        
        HBox cuatro = new HBox();
        cuatro.setAlignment(Pos.CENTER);
        cuatro.setPrefHeight(10);
        
        AnchorPane es = new AnchorPane();
        es.setPrefHeight(15);
        AnchorPane es2 = new AnchorPane();
        es2.setPrefHeight(8);
        AnchorPane es3 = new AnchorPane();
        es3.setPrefHeight(20);
        AnchorPane es4 = new AnchorPane();
        es4.setPrefHeight(15);
        
        Label lb1 = new Label("Cambiar Contraseña");
        Label lb2 = new Label("Contraseña actual:  ");
        Label lb3 = new Label("Contraseña nueva:  ");
        Label lb4 = new Label("");
        Button bt1 = new Button ("Aceptar");
        Button bt2 = new Button ("Cancelar");
        
        PasswordField tx1 = new PasswordField();
        PasswordField tx2 = new PasswordField();
        
        bt1.setOnMouseClicked(e -> {
            String actualCorreo = tx1.getText();
            String nuevoCorreo = tx2.getText();

            if (App.cliente.getPassword().equals(actualCorreo)) {
                try {
                    User.actualizarArchivo(App.cliente.getEmail(), App.cliente.getEmail(), nuevoCorreo, App.cliente.getNombre(), App.cliente.getApellido());
                    App.cliente.setPassword(nuevoCorreo);
                    Stage s = (Stage) bt1.getScene().getWindow();
                    s.close();
                    App.setRoot("Ajustes");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                lb4.setText("La contraseña actual no es correcta");
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
        
        lb1.setStyle("-fx-font-family: 'Montserrat'; -fx-font-weight: bold; -fx-font-size: 24px; -fx-text-fill: white");
        lb2.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px; -fx-text-fill: white");
        lb3.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 18px; -fx-text-fill: white");
        lb4.setStyle("-fx-font-family: 'Montserrat'; -fx-font-size: 16px; -fx-text-fill: white");
        bt1.setStyle("-fx-background-color: white; -fx-font-family: 'Montserrat'; -fx-text-fill: #373766; -fx-font-weight: bold; -fx-font-size: 16px");
        bt2.setStyle("-fx-background-color: white; -fx-font-family: 'Montserrat'; -fx-text-fill: #373766; -fx-font-weight: bold; -fx-font-size: 16px");
        detalle.setStyle("-fx-background-color:  #373766;");
        
        uno.getChildren().addAll(lb2, tx1);
        dos.getChildren().addAll(lb3, tx2);
        tres.getChildren().addAll(bt1, bt2);
        cuatro.getChildren().addAll(lb4);
        detalle.getChildren().addAll(lb1, es, uno, es2, dos, es3, tres, es4, cuatro);
        
        Scene s = new Scene(detalle, 420, 300);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Cambiar Contraseña");
        stage.show();
    }
    
}
