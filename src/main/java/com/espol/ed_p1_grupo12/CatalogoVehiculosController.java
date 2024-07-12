package com.espol.ed_p1_grupo12;

import Modelo.Vehiculo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

public class CatalogoVehiculosController {
    @FXML private TableView<Vehiculo> vehiculosTableView;
    @FXML private TableColumn<Vehiculo, String> marcaColumn;
    @FXML private TableColumn<Vehiculo, String> modeloColumn;
    @FXML private TableColumn<Vehiculo, Integer> añoColumn;
    @FXML private TableColumn<Vehiculo, Double> precioColumn;
    @FXML private TableColumn<Vehiculo, Integer> kilometrajeColumn;
    @FXML private TableColumn<Vehiculo, String> motorColumn;
    @FXML private TableColumn<Vehiculo, String> transmisionColumn;
    @FXML private TableColumn<Vehiculo, Double> pesoColumn;
    @FXML private TableColumn<Vehiculo, String> ubicacionColumn;
    @FXML private TableColumn<Vehiculo, String> historialAccidentesColumn;
    @FXML private TableColumn<Vehiculo, String> historialReparacionesColumn;
    @FXML private TableColumn<Vehiculo, String> historialMantenimientoColumn;

    @FXML
    public void initialize() {
        // Configurar columnas
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        añoColumn.setCellValueFactory(new PropertyValueFactory<>("año"));
        precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        kilometrajeColumn.setCellValueFactory(new PropertyValueFactory<>("kilometraje"));
        motorColumn.setCellValueFactory(new PropertyValueFactory<>("motor"));
        transmisionColumn.setCellValueFactory(new PropertyValueFactory<>("transmision"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("peso"));
        ubicacionColumn.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        historialAccidentesColumn.setCellValueFactory(new PropertyValueFactory<>("historialAccidentes"));
        historialReparacionesColumn.setCellValueFactory(new PropertyValueFactory<>("historialReparaciones"));
        historialMantenimientoColumn.setCellValueFactory(new PropertyValueFactory<>("historialMantenimiento"));

        // Cargar datos de vehículos
        Set<Vehiculo> vehiculos = leerVehiculos();
        vehiculosTableView.setItems(FXCollections.observableArrayList(vehiculos));
    }

    private Set<Vehiculo> leerVehiculos() {
        Set<Vehiculo> vehiculos = new HashSet<>();
        try {
            FileInputStream fileIn = new FileInputStream("vehiculos.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Vehiculo vehiculo;
            while ((vehiculo = (Vehiculo) in.readObject()) != null) {
                vehiculos.add(vehiculo);
            }
            in.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}