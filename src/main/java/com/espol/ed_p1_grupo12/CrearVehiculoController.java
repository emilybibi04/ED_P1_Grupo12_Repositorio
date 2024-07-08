package com.espol.ed_p1_grupo12;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cykes
 */
import Modelo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearVehiculoController {
    @FXML private TextField marcaField;
    @FXML private TextField modeloField;
    @FXML private TextField añoField;
    @FXML private TextField precioField;
    @FXML private TextField kilometrajeField;
    @FXML private TextField motorField;
    @FXML private TextField transmisionField;
    @FXML private TextField pesoField;
    @FXML private TextField ubicacionField;
    @FXML private TextField historialAccidentesField;
    @FXML private TextField historialReparacionesField;
    @FXML private TextField historialMantenimientoField;
    @FXML private TextField fotoField;

    private String fotoPath;

    @FXML
    private void handleSubirFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            fotoPath = file.getAbsolutePath();
            fotoField.setText(fotoPath);
        }
    }

    @FXML
    private void handleCrearVehiculo(ActionEvent event) {
        try {
            Vehiculo vehiculo = new Vehiculo(
                    marcaField.getText(),
                    modeloField.getText(),
                    Integer.parseInt(añoField.getText()),
                    Double.parseDouble(precioField.getText()),
                    Integer.parseInt(kilometrajeField.getText()),
                    motorField.getText(),
                    transmisionField.getText(),
                    ubicacionField.getText(),
                    historialAccidentesField.getText(),
                    historialReparacionesField.getText(),
                    historialMantenimientoField.getText()
            );

            FileOutputStream fileOut = new FileOutputStream("vehiculos.dat", true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(vehiculo);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void switchToInicio () throws IOException {
        App.setRoot("Menu");
    }
}