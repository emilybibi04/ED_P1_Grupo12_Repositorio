package com.espol.ed_p1_grupo12;

import Modelo.Vehiculo;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class InformacionController implements Initializable {

    
    @FXML
    TextField modelo_text;
    @FXML
    TextField marca_text;
    @FXML
    TextField anio_text;
    @FXML
    TextField precio_text;
    @FXML
    TextField kilo_text;
    @FXML
    TextField motor_text;
    @FXML
    TextField tran_text;
    @FXML
    TextField ubi_text;
    @FXML
    ComboBox cmb_carros;
    @FXML
    HBox fotos_panel;
    @FXML
    Label lbl_carro1;
    @FXML
    Label lbl_carro2;
    @FXML
    Label lbl_propietario;
    @FXML
    HBox panel_der;
    @FXML
    HBox panel_izq;
    
    static ArrayList<Vehiculo> vehiculosRegistrados = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        colocarFoto();
    }

    public void colocarFoto(){
        fotos_panel.getChildren().clear();
        panel_der.getChildren().clear();
        panel_izq.getChildren().clear();
        ImageView imgView = new ImageView();
        ImageView imgView1 = new ImageView();
        ImageView imgView2 = new ImageView();
        try(FileInputStream input = new FileInputStream(App.pathCarros + "Tesla.jpg")){
                Image image = new Image(input);
                imgView = new ImageView(image);
                imgView.setFitHeight(326);
                imgView.setFitWidth(353);
            } catch(IOException e){
                System.out.println("No se encuentra la imagen");
            }
        
        try(FileInputStream input = new FileInputStream(App.pathImg + "Flecha_izq.png")){
                Image image = new Image(input);
                imgView1 = new ImageView(image);
                imgView1.setFitHeight(45);
                imgView1.setFitWidth(31);
            } catch(IOException e){
                System.out.println("No se encuentra la imagen");
            }
        
        try(FileInputStream input = new FileInputStream(App.pathImg + "Flecha_der.png")){
                Image image = new Image(input);
                imgView2 = new ImageView(image);
                imgView2.setFitHeight(45);
                imgView2.setFitWidth(31);
            } catch(IOException e){
                System.out.println("No se encuentra la imagen");
            }

        fotos_panel.getChildren().addAll(imgView);
        panel_izq.getChildren().addAll(imgView1);
        panel_der.getChildren().addAll(imgView2);
    }
    
}
