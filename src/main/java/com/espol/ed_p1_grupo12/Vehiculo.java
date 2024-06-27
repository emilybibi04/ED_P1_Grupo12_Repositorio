/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;

/**
 *
 * @author jorge
 */
public class Vehiculo {
    //private int peso;
    private static int codigo=0;
    private String marca;
    private String modelo;
    private int año;
    private float kilometraje;
    private float precio;
    private Motor motor;
    private Transmision transmision;
    private Locacion locacion;
    private HistorialServicio historialDeServicio;
    private HistorialAccidentes historialDeAccidente;

    public Vehiculo(String marca, String modelo, int año, float kilometraje, float precio, Motor motor, Transmision transmision, Locacion locacion, HistorialServicio historialDeServicio, HistorialAccidentes historialDeAccidente) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.motor = motor;
        this.transmision = transmision;
        this.locacion = locacion;
        this.historialDeServicio = historialDeServicio;
        this.historialDeAccidente = historialDeAccidente;
        this.codigo=codigo++;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public float getPrecio() {
        return precio;
    }

    public Motor getMotor() {
        return motor;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public Locacion getLocacion() {
        return locacion;
    }

    public HistorialServicio getHistorialDeServicio() {
        return historialDeServicio;
    }

    public HistorialAccidentes getHistorialDeAccidente() {
        return historialDeAccidente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public void setLocacion(Locacion locacion) {
        this.locacion = locacion;
    }

    public void setHistorialDeServicio(HistorialServicio historialDeServicio) {
        this.historialDeServicio = historialDeServicio;
    }

    public void setHistorialDeAccidente(HistorialAccidentes historialDeAccidente) {
        this.historialDeAccidente = historialDeAccidente;
    }
    
    
}
