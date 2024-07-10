/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Modelo;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public interface Writer {
    
     static void escribirUsuarios(Set<User> usuarios, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (User usuario : usuarios) {
                writer.write(usuario.getEmail() + "," + usuario.getPassword() +","+usuario.getNombre()+ ","+ usuario.getApellido() +"\n");
            }
            System.out.println("Usuarios actualizados en el archivo");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo " + nombreArchivo);
            e.printStackTrace();
        }
    }
}
