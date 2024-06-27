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
public class ConjuntoVehiculos {
    private Deque<Vehiculo> vehiculos;

    public ConjuntoVehiculos(Deque<Vehiculo> vehiculos) {
        this.vehiculos = new ArrayDeque<>();
    }
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.push(vehiculo);
    }

    public Deque<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public Vehiculo getVehiculo(int index) {
        if (index < 0 || index >= vehiculos.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        // Debido a que la Deque no tiene un método directo get(index), se debe iterar
        Vehiculo vehiculo = null;
        int currentIndex = 0;
        for (Vehiculo vehiculoItem : vehiculos) {
            if (currentIndex == index) {
                vehiculo = vehiculoItem;
                break;
            }
            currentIndex++;
        }
        return vehiculo;
    }
    public Deque<Vehiculo> buscarVehiculos(int codigo) {
        Deque<Vehiculo> resultados = new ArrayDeque<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getCodigo() == codigo) {
                resultados.add(vehiculo);
            }
        }
        return resultados;
    }
    
    
}
