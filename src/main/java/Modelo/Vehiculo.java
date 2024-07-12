package Modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private String nombrePropietario;
    private String apellidoPropietario;
    private String rutaImagen;

    public Vehiculo(String marca, String modelo, int año, double precio, int kilometraje, String motor,
                    String transmision, String ubicacion, String historialAccidentes,
                    String historialReparaciones, String historialMantenimiento, String nombrePropietario, String apellidoPropietario, String rutaImagen) {
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
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.rutaImagen = rutaImagen;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getApellidoPropietario() {
        return apellidoPropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public void setApellidoPropietario(String apellidoPropietario) {
        this.apellidoPropietario = apellidoPropietario;
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
    
    public static Set<Vehiculo> objetoVehiculos(String nombrearchivo) throws IOException{
        
        Set<String> lineas = Readable.leerArchivo(nombrearchivo);
        Set<Vehiculo> vehiculos = new LinkedHashSet<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            String marca = elemento[0];
            String modelo = elemento[1];
            int año = Integer.parseInt(elemento[2]);
            double precio = Double.parseDouble(elemento[3]);
            int kilometraje = Integer.parseInt(elemento[4]);
            String motor = elemento[5];
            String transmision = elemento[6];
            String ubicacion = elemento[7] + ", " + elemento[8];
            String historialAccidentes = elemento[9];
            String historialReparaciones = elemento[10];
            String historialMantenimiento = elemento[11];
            String n = elemento[12];
            String a = elemento[13];
            String i = elemento[14];
            vehiculos.add(new Vehiculo(marca, modelo, año, precio, kilometraje, motor, transmision, ubicacion, historialAccidentes, historialReparaciones, historialMantenimiento, n, a,i ));        }
        
        return vehiculos;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }


    
}