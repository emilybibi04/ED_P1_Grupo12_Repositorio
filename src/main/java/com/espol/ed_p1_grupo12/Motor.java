/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;

/**
 *
 * @author jorge
 */
public class Motor {
    private String tipo;
    private int cilindraje;
    private int potencia;

    public Motor(String tipo, int cilindraje, int potencia) {
        this.tipo = tipo;
        this.cilindraje = cilindraje;
        this.potencia = potencia;
    }
    
    
    public String getTipo() {
        return tipo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    
}
