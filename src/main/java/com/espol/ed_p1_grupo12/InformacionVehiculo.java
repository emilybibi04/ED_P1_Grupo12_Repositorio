/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author jorge
 */
public class InformacionVehiculo {
    private Vehiculo vehiculo;
    private Deque<String> fotos; // Lista de rutas de las imágenes
    private String descripcion;
    private Deque<String> caracteristicas; // Lista de características del vehículo

    
    public InformacionVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.fotos = new ArrayDeque<>();
        this.descripcion = "";
        this.caracteristicas = new ArrayDeque<>();
    }
}
