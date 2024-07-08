/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Vehiculo implements Serializable {
    private String marca;
    private String modelo;
    private int año;
    private double precio;
    private int kilometraje;
    private String motor;
    private String transmision;
    private String ubicacion;
    private String historialAccidentes;
    private String historialReparaciones;
    private String historialMantenimiento;

    // Constructor
    public Vehiculo(String marca, String modelo, int año, double precio, int kilometraje, String motor,
                    String transmision, String ubicacion, String historialAccidentes,
                    String historialReparaciones, String historialMantenimiento) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.motor = motor;
        this.transmision = transmision;
        this.ubicacion = ubicacion;
        this.historialAccidentes = historialAccidentes;
        this.historialReparaciones = historialReparaciones;
        this.historialMantenimiento = historialMantenimiento;
        
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHistorialAccidentes() {
        return historialAccidentes;
    }

    public void setHistorialAccidentes(String historialAccidentes) {
        this.historialAccidentes = historialAccidentes;
    }

    public String getHistorialReparaciones() {
        return historialReparaciones;
    }

    public void setHistorialReparaciones(String historialReparaciones) {
        this.historialReparaciones = historialReparaciones;
    }

    public String getHistorialMantenimiento() {
        return historialMantenimiento;
    }

    public void setHistorialMantenimiento(String historialMantenimiento) {
        this.historialMantenimiento = historialMantenimiento;
    }
    
    public static ArrayList<Vehiculo> objetoVehiculos(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            String marca = elemento[0];
            String modelo = elemento[0];
//            int año = elemento[0];
//            double precio = elemento[0];
//            int kilometraje = elemento[0];
            String motor = elemento[0];
            String transmision = elemento[0];
            String ubicacion = elemento[0];
            String historialAccidentes = elemento[0];
            String historialReparaciones = elemento[0];
            String historialMantenimiento = elemento[0];
            
//            vehiculos.add(new User(correo, contraseña));
        }
        
        return vehiculos;
    }


    
}