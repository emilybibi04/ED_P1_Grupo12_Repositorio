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
public class HistorialServicio {
    private Deque<ServicioRecord> recordsServicio;

    // Constructor
    public HistorialServicio() {
        this.recordsServicio = new ArrayDeque<>();
    }

    public void addServiceRecord(ServicioRecord recordServicio) {
        recordsServicio.add(recordServicio);
    }

    // Métodos para obtener la lista de registros de servicio y detalles específicos

    public Deque<ServicioRecord> getRecordsServicio() {
        return recordsServicio;
    }
    
    public ServicioRecord getServiceRecord(int index) {
        if (index < 0 || index >= recordsServicio.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        ServicioRecord record = null;
        int currentIndex = 0;
        for (ServicioRecord recordItem : recordsServicio) {
            if (currentIndex == index) {
                record = recordItem;
                break;
            }
            currentIndex++;
        }
        return record;
    }
}

