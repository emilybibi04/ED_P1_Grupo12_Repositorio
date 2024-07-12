package com.espol.ed_p1_grupo12;

import Modelo.Vehiculo;
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
import java.util.LinkedHashSet;
import java.util.Set;

public class InformacionController implements Initializable {
    
    @FXML TextField anio_text;
    @FXML TextField precio_text;
    @FXML TextField kilo_text;
    @FXML TextField motor_text;
    @FXML TextField tran_text;
    @FXML TextField ubi_text;
    @FXML ComboBox cmb_carros;
    @FXML HBox fotos_panel;
    @FXML Label lbl_carro1;
    @FXML Label lbl_carro2;
    @FXML Label lbl_propietario;
    @FXML HBox panel_der;
    @FXML HBox panel_izq;
    @FXML Label lbl_pro;
    
    public static Set<Vehiculo> vehiculosRegistrados = new LinkedHashSet<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmb_carros.setStyle("-fx-font-size: 15px; -fx-background-color: white; -fx-font-family: 'Montserrat'");
        try {
            vehiculosRegistrados = Vehiculo.objetoVehiculos(App.pathArchivo + "vehiculos.txt");
            for (Vehiculo v : vehiculosRegistrados){
                cmb_carros.getItems().addAll(v.getMarca() + " - " + v.getModelo());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    void mostrarCarro(ActionEvent event){
        String tipo = (String) cmb_carros.getValue();
        fotos_panel.getChildren().clear();
        anio_text.setText("");
        precio_text.setText("");
        kilo_text.setText("");
        motor_text.setText("");
        tran_text.setText("");
        ubi_text.setText("");
        lbl_carro1.setText("");
        lbl_carro2.setText("");
        lbl_propietario.setText("");
        
        try{
            colocarFoto(tipo);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void switchToMenu () throws IOException {
        App.setRoot("Menu");
    }

    public void colocarFoto(String t) throws IOException {
        String[] tipo = t.split("-");
        String marca = tipo[0].trim();
        String modelo = tipo[1].trim();

        lbl_pro.setText("Propietario");

        for (Vehiculo v : vehiculosRegistrados) {
            if (modelo.equals(v.getModelo())) {
                anio_text.setText(String.valueOf(v.getAño()));
                precio_text.setText(String.valueOf(v.getPrecio()) + " USD");
                kilo_text.setText(String.valueOf(v.getKilometraje()));
                motor_text.setText(v.getMotor());
                tran_text.setText(v.getTransmision());
                ubi_text.setText(v.getUbicacion());
                lbl_carro1.setText(v.getModelo());
                lbl_carro2.setText(v.getMarca());
                lbl_propietario.setText(v.getNombrePropietario() + " " + v.getApellidoPropietario());

                // Cargar la imagen del vehículo
                ImageView imgView = new ImageView();
                try (FileInputStream input = new FileInputStream(v.getRutaImagen())) {
                    Image image = new Image(input);
                    imgView = new ImageView(image);
                    imgView.setFitHeight(326);
                    imgView.setFitWidth(353);
                } catch (IOException e) {
                    System.out.println("No se encuentra la imagen: " + v.getRutaImagen());
                }

                fotos_panel.getChildren().clear();
                fotos_panel.getChildren().addAll(imgView);
                break;
            }
        }

        // Cargar las imágenes de las flechas
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
    
}
