package com.espol.ed_p1_grupo12;

import Modelo.Seccion;
import Modelo.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
        App.cliente = Seccion.getLoggedUser();
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
                String nuevoNombre = tx1.getText();
                String nuevoApellido = tx2.getText();
                User.actualizarArchivo(App.cliente.getEmail(), App.cliente.getEmail(), App.cliente.getPassword(), nuevoNombre, nuevoApellido);
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
        Label lb4 = new Label("");
        Button bt1 = new Button ("Aceptar");
        Button bt2 = new Button ("Cancelar");
        
        TextField tx1 = new TextField();
        TextField tx2 = new TextField();
        
        bt1.setOnMouseClicked(e -> {
            String actualCorreo = tx1.getText();
            String nuevoCorreo = tx2.getText();

            if (App.cliente.getPassword().equals(actualCorreo)) {
                try {
                    // Actualizar la contraseña y el archivo correspondiente
                    User.actualizarArchivo(App.cliente.getEmail(), App.cliente.getEmail(), nuevoCorreo, App.cliente.getNombre(), App.cliente.getApellido());
                    App.cliente.setPassword(nuevoCorreo);

                    // Cerrar la ventana actual
                    Stage s = (Stage) bt1.getScene().getWindow();
                    s.close();

                    // Mostrar mensaje de éxito o hacer lo que sea necesario
                    lb4.setText("Contraseña cambiada correctamente.");

                    // Cambiar la vista a "Ajustes"
                    App.setRoot("Ajustes");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                // Mostrar mensaje de error en lb4
                lb4.setText("La contraseña actual ingresada no es correcta.");
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
        detalle.getChildren().addAll(lb1, uno, dos, lb4, bt1, bt2);
        
        Scene s = new Scene(detalle, 420, 250);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Cambiar Contraseña");
        stage.show();
    }
    
}
