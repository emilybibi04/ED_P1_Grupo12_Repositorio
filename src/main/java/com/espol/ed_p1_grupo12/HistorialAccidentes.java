/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 *
 * @author jorge
 */
public class HistorialAccidentes {
    private Deque<Accidente> accidentes;

    // Constructor
    public HistorialAccidentes () {
        this.accidentes = new ArrayDeque<>();
    }

    public void addAccident(Accidente accidente) {
        accidentes.add(accidente);
    }
    
    public Deque<Accidente> getAccidentes() {
        return accidentes;
    }

}
