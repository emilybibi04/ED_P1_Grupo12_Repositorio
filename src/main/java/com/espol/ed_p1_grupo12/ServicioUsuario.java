/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.ed_p1_grupo12;
import java.io.*;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cykes
 */
public class ServicioUsuario {
    private static final String archivo = "usuarios.txt";

    public boolean verificar(String email, String password){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(email)) {
                    String encriptar = new String(Base64.getDecoder().decode(parts[1]));
                    return password.equals(encriptar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean registrarUsuario(String email, String password) {
        if(isEmailRegistrado(email)){
            return false;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            String encriptar = Base64.getEncoder().encodeToString(password.getBytes());
            bw.write(email + "," + encriptar);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; //Se daño el sistema
        
    }
    
    private boolean isEmailRegistrado(String email) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(email)) {
                    return true; // El correo ya está registrado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // El correo no está registrado
    }
}
