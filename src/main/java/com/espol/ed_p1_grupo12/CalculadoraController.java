package com.espol.ed_p1_grupo12;

import Modelo.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculadoraController implements Initializable {

    @FXML private ComboBox<String> comboBox1;
    @FXML private ComboBox<String> comboBox2;
    @FXML private Label resultLabel;
    @FXML private TextField lbl_year1;
    @FXML private TextField lbl_precio1;
    @FXML private TextField lbl_kilo1;
    @FXML private TextField lbl_motor1;
    @FXML private TextField lbl_trans1;
    
    @FXML private TextField lbl_year2;
    @FXML private TextField lbl_precio2;
    @FXML private TextField lbl_kilo2;
    @FXML private TextField lbl_motor2;
    @FXML private TextField lbl_trans2;
    
    @FXML private Label lbl_c11;
    @FXML private Label lbl_c12;
    @FXML private Label lbl_c21;
    @FXML private Label lbl_c22;
    
    private Set<Vehiculo> vehiculosRegistrados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox1.setStyle("-fx-font-size: 15px; -fx-background-color: white; -fx-font-family: 'Montserrat'");
        comboBox2.setStyle("-fx-font-size: 15px; -fx-background-color: white; -fx-font-family: 'Montserrat'");

        try {
            Set<Vehiculo> vehiculosSet = Vehiculo.objetoVehiculos(App.pathArchivo + "vehiculos.txt");
            vehiculosRegistrados = new LinkedHashSet<>(vehiculosSet); // Using LinkedHashSet to maintain insertion order

            for (Vehiculo v : vehiculosRegistrados) {
                comboBox1.getItems().add(v.getMarca() + " - " + v.getModelo());
                comboBox2.getItems().add(v.getMarca() + " - " + v.getModelo());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void compararCarros() {
        String seleccion1 = comboBox1.getValue();
        String seleccion2 = comboBox2.getValue();

        if (seleccion1 != null && seleccion2 != null) {
            Vehiculo carro1 = obtenerVehiculo(seleccion1);
            Vehiculo carro2 = obtenerVehiculo(seleccion2);

            if (carro1 != null && carro2 != null) {
                
                lbl_c11.setText(carro1.getMarca());
                lbl_c12.setText(carro1.getModelo());
                lbl_year1.setText(String.valueOf(carro1.getAño()));
                lbl_precio1.setText(String.valueOf(carro1.getPrecio()));
                lbl_kilo1.setText(String.valueOf(carro1.getKilometraje()));
                lbl_motor1.setText(carro1.getMotor());
                lbl_trans1.setText(carro1.getTransmision());
    
                lbl_c21.setText(carro2.getMarca());
                lbl_c22.setText(carro2.getModelo());
                lbl_year2.setText(String.valueOf(carro2.getAño()));
                lbl_precio2.setText(String.valueOf(carro2.getPrecio()));
                lbl_kilo2.setText(String.valueOf(carro2.getKilometraje()));
                lbl_motor2.setText(carro2.getMotor());
                lbl_trans2.setText(carro2.getTransmision());
                
                Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getPrecio)
                        .thenComparing(Vehiculo::getKilometraje)
                        .thenComparing(Vehiculo::getAño);

                int comparacion = comparator.compare(carro1, carro2);
                String mejorCarro = comparacion > 0 ? carro2.getMarca() + " - " + carro2.getModelo() + " es mejor que " + carro1.getMarca() + " - " + carro1.getModelo() :
                        (comparacion < 0 ? carro1.getMarca() + " - " + carro1.getModelo() + " es mejor que " + carro2.getMarca() + " - " + carro2.getModelo() :
                                "Ambos carros son iguales en los criterios comparados.");

                
                resultLabel.setText(mejorCarro);
            }
        } else {
            resultLabel.setText("Por favor, selecciona dos carros para comparar.");
        }
    }

    private Vehiculo obtenerVehiculo(String seleccion) {
        for (Vehiculo v : vehiculosRegistrados) {
            if ((v.getMarca() + " - " + v.getModelo()).equals(seleccion)) {
                return v;
            }
        }
        return null;
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("Menu");
    }
    
}