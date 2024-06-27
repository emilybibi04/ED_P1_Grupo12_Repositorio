/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private String marca;
    private String modelo;
    private int año;
    private double precio;
    private int kilometraje;
    private String motor;
    private String transmision;
    private double peso;
    private String ubicacion;
    private String historialAccidentes;
    private String historialReparaciones;
    private String historialMantenimiento;
    private String foto;

    // Constructor
    public Vehiculo(String marca, String modelo, int año, double precio, int kilometraje, String motor,
                    String transmision, double peso, String ubicacion, String historialAccidentes,
                    String historialReparaciones, String historialMantenimiento, String foto) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.motor = motor;
        this.transmision = transmision;
        this.peso = peso;
        this.ubicacion = ubicacion;
        this.historialAccidentes = historialAccidentes;
        this.historialReparaciones = historialReparaciones;
        this.historialMantenimiento = historialMantenimiento;
        this.foto = foto;
        
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}