/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;

import java.util.Date;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 *
 * @author jorge
 */
public class ServicioRecord { 
    private Date fecha;
    private String tipoServicio;
    private Deque<String> piezasReemplazadas; //reparaciones, Procesos de mantenimiento

    public ServicioRecord(Date fecha, String tipoServicio, Deque<String> piezasReemplazadas) {
        this.fecha = fecha;
        this.tipoServicio = tipoServicio;
        this.piezasReemplazadas = piezasReemplazadas;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public Deque<String> getPiezasReemplazadas() {
        return piezasReemplazadas;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setPiezasReemplazadas(Deque<String> piezasReemplazadas) {
        this.piezasReemplazadas = piezasReemplazadas;
    }


    
    
}
