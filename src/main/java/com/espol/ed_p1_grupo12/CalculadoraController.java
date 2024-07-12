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

public class CalculadoraController implements Initializable {

    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private ComboBox<String> comboBox2;
    @FXML
    private Label resultLabel;

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
                String infoCarro1 = carro1.toString();
                String infoCarro2 = carro2.toString();
                // Comparador para comparar por precio, kilometraje y año
                Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getPrecio)
                        .thenComparing(Vehiculo::getKilometraje)
                        .thenComparing(Vehiculo::getAño);

                int comparacion = comparator.compare(carro1, carro2);
                String mejorCarro = comparacion > 0 ? carro2.getMarca() + " - " + carro2.getModelo() + " es mejor que " + carro1.getMarca() + " - " + carro1.getModelo() :
                        (comparacion < 0 ? carro1.getMarca() + " - " + carro1.getModelo() + " es mejor que " + carro2.getMarca() + " - " + carro2.getModelo() :
                                "Ambos carros son iguales en los criterios comparados.");

                resultLabel.setText("Información del Carro 1:\n" + infoCarro1 + "\n\nInformación del Carro 2:\n" + infoCarro2 + "\n\n" + mejorCarro);
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
}