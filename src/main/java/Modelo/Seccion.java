/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cykes
 */
public class Seccion {
    private static User logged;

    public static void setLoggedUser(User user) {
        logged = user;
    }

    public static User getLoggedUser() {
        return logged;
    }
}
