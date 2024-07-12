package com.espol.ed_p1_grupo12;

import Modelo.Vehiculo;
import static com.espol.ed_p1_grupo12.CrearVehiculoController.vehiculosCreados;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MisVehiculosController implements Initializable {

    @FXML TextField anio_text_V;
    @FXML TextField precio_text_V;
    @FXML TextField kilo_text_V;
    @FXML TextField motor_text_V;
    @FXML TextField tran_text_V;
    @FXML TextField ubi_text_V;
    @FXML ComboBox cmb_carros_V;
    @FXML HBox fotos_panel;
    @FXML Label lbl_carro1;
    @FXML Label lbl_carro2;
    @FXML Label lbl_propietario;
    @FXML HBox panel_der;
    @FXML HBox panel_izq;
    @FXML Label lbl_pro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmb_carros_V.setStyle("-fx-font-size: 15px; -fx-background-color: white; -fx-font-family: 'Montserrat'");
        for (Vehiculo v : vehiculosCreados){
        cmb_carros_V.getItems().addAll(v.getMarca() + " - " + v.getModelo());}
            
        
    }   
    
    @FXML
    private void switchToMenu () throws IOException {
        App.setRoot("Menu");
    }
    @FXML
    void mostrarCarro(ActionEvent event){
        String tipo = (String) cmb_carros_V.getValue();
        fotos_panel.getChildren().clear();
        anio_text_V.setText("");
        precio_text_V.setText("");
        kilo_text_V.setText("");
        motor_text_V.setText("");
        tran_text_V.setText("");
        ubi_text_V.setText("");
        lbl_carro1.setText("");
        lbl_carro2.setText("");
        lbl_propietario.setText("");
        
        try{
            colocarFoto(tipo);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void colocarFoto(String t) throws IOException {
        String[] tipo = t.split("-");
        String marca = tipo[0].trim();
        String modelo = tipo[1].trim();

        lbl_pro.setText("Propietario");

        for (Vehiculo v : vehiculosCreados) {
            if (modelo.equals(v.getModelo())) {
                anio_text_V.setText(String.valueOf(v.getAño()));
                precio_text_V.setText(String.valueOf(v.getPrecio()) + " USD");
                kilo_text_V.setText(String.valueOf(v.getKilometraje()));
                motor_text_V.setText(v.getMotor());
                tran_text_V.setText(v.getTransmision());
                ubi_text_V.setText(v.getUbicacion());
                lbl_carro1.setText(v.getModelo());
                lbl_carro2.setText(v.getMarca());
                lbl_propietario.setText(v.getNombrePropietario() + " " + v.getApellidoPropietario());

                // Cargar la imagen del vehículo por directorio de vehiculos.txt
                ImageView imgView = new ImageView();
                try {
                    String imagePath = "/".concat(v.getRutaImagen());
                    Image image = new Image(getClass().getResourceAsStream(imagePath));
                    imgView = new ImageView(image);
                    imgView.setFitHeight(326);
                    imgView.setFitWidth(353);
                } catch (Exception e) {
                    System.out.println("No se encuentra la imagen: " + v.getRutaImagen());
                }

                fotos_panel.getChildren().clear();
                fotos_panel.getChildren().addAll(imgView);
                break;
            }
        }

        panel_der.getChildren().clear();
        panel_izq.getChildren().clear();
        ImageView imgView1 = new ImageView();
        ImageView imgView2 = new ImageView();
        try (FileInputStream input = new FileInputStream(App.pathImg + "Flecha_izq.png")) {
            Image image = new Image(input);
            imgView1 = new ImageView(image);
            imgView1.setFitHeight(45);
            imgView1.setFitWidth(31);
        } catch (IOException e) {
            System.out.println("No se encuentra la imagen");
        }

        try (FileInputStream input = new FileInputStream(App.pathImg + "Flecha_der.png")) {
            Image image = new Image(input);
            imgView2 = new ImageView(image);
            imgView2.setFitHeight(45);
            imgView2.setFitWidth(31);
        } catch (IOException e) {
            System.out.println("No se encuentra la imagen");
        }

        panel_izq.getChildren().addAll(imgView1);
        panel_der.getChildren().addAll(imgView2);
    }
    
    @FXML
    private void switchToCrearVehiculos () throws IOException {
        App.setRoot("CrearVehiculo");
    }
    
    @FXML
    private void eliminarVehiculo() throws IOException{
        String tipo = (String) cmb_carros_V.getValue();
    
        if (tipo == null || tipo.isEmpty()) {
            System.out.println("No se ha seleccionado ningún vehículo.");
            return;
        }

        String[] tipoSplit = tipo.split("-");
        String marca = tipoSplit[0].trim();
        String modelo = tipoSplit[1].trim();

        Vehiculo vehiculoAEliminar = null;
        for (Vehiculo v : vehiculosCreados) {
            if (v.getMarca().equals(marca) && v.getModelo().equals(modelo)) {
                vehiculoAEliminar = v;
                break;
            }
        }

        if (vehiculoAEliminar != null) {
            vehiculosCreados.remove(vehiculoAEliminar);
            cmb_carros_V.getItems().remove(tipo);
            System.out.println("Vehículo eliminado: " + marca + " - " + modelo);

            // Limpiar los campos de texto y las imágenes
            anio_text_V.setText("");
            precio_text_V.setText("");
            kilo_text_V.setText("");
            motor_text_V.setText("");
            tran_text_V.setText("");
            ubi_text_V.setText("");
            lbl_carro1.setText("");
            lbl_carro2.setText("");
            lbl_propietario.setText("");
            fotos_panel.getChildren().clear();
        } else {
            System.out.println("Vehículo no encontrado: " + marca + " - " + modelo);
        }
    }
    
}
