package com.espol.ed_p1_grupo12;

import Modelo.Seccion;
import Modelo.User;
import Modelo.Vehiculo;
import java.io.BufferedWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class CrearVehiculoController {
    @FXML private TextField marcaField;
    @FXML private TextField modeloField;
    @FXML private TextField añoField;
    @FXML private TextField precioField;
    @FXML private TextField kilometrajeField;
    @FXML private TextField motorField;
    @FXML private TextField transmisionField;
    @FXML private TextField ciudadField;
    @FXML private TextField paisField;
    @FXML private TextField historialAccidentesField;
    @FXML private TextField historialReparacionesField;
    @FXML private TextField historialMantenimientoField;
    @FXML private TextField fotoField;
    @FXML private TextField nombreField;
    @FXML private TextField apellidoField;

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
    static Set<Vehiculo> vehiculosCreados = new LinkedHashSet<>();
    @FXML
    private void handleCrearVehiculo(ActionEvent event) {
        User loggedUser = Seccion.getLogged();
        try {
            // Crea una cadena con los datos del vehículo
            String vehiculoData = marcaField.getText() + "," +
                                  modeloField.getText() + "," +
                                  añoField.getText() + "," +
                                  precioField.getText() + "," +
                                  kilometrajeField.getText() + "," +
                                  motorField.getText() + "," +
                                  transmisionField.getText() + "," +
                                  ciudadField.getText() + "," + paisField.getText() + "," +
                                  historialAccidentesField.getText() + "," +
                                  historialReparacionesField.getText() + "," +
                                  historialMantenimientoField.getText() + "," +
                                  loggedUser.getNombre() + "," +
                                  loggedUser.getApellido()+ "," +
                                  fotoField.getText(); 

            // Escribe la cadena en el archivo
            FileWriter fileWriter = new FileWriter(App.pathArchivo + "vehiculos.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(vehiculoData + "\n");
            bufferedWriter.close();
            fileWriter.close();
            String ubicacion=ciudadField.getText() + "," + paisField.getText();
            Vehiculo vehiculo=new Vehiculo(marcaField.getText(),modeloField.getText(),Integer.parseInt(añoField.getText()),Double.parseDouble(precioField.getText()),Integer.parseInt(kilometrajeField.getText()),motorField.getText(),transmisionField.getText(),ubicacion,historialAccidentesField.getText(),historialReparacionesField.getText(),historialMantenimientoField.getText(),loggedUser.getNombre(),loggedUser.getApellido(),fotoField.getText());
            vehiculosCreados.add(vehiculo); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    @FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Menu");
    }
}