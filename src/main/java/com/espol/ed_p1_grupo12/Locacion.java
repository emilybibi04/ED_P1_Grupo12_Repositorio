/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;

/**
 *
 * @author jorge
 */
public class Locacion {
    private double latitud;
    private String ciudad;
    private double longitud;

    public Locacion(double latitud, String ciudad, double longitud) {
        this.latitud = latitud;
        this.ciudad = ciudad;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
}
