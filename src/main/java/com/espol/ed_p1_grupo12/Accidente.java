/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;

import java.util.Date;

/**
 *
 * @author jorge
 */
public class Accidente {
    
    private Date fecha;
    private String tipoAccidente;
    private String dañosSufridos;

    public Accidente(Date fecha, String tipoAccidente, String dañosSufridos) {
        this.fecha = fecha;
        this.tipoAccidente = tipoAccidente;
        this.dañosSufridos = dañosSufridos;
    }
    

    public Date getFecha() {
        return fecha;
    }

    public String getTipoAccidente() {
        return tipoAccidente;
    }

    public String getDañosSufridos() {
        return dañosSufridos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipoAccidente(String tipoAccidente) {
        this.tipoAccidente = tipoAccidente;
    }

    public void setDañosSufridos(String dañosSufridos) {
        this.dañosSufridos = dañosSufridos;
    }

    

    

}
