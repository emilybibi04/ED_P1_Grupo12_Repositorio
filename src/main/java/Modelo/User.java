package Modelo;

import java.io.IOException;
import java.util.ArrayList;

public class User {
    private String email;
    private String password;
    private String nombre;
    private String apellido;

    public User(String email, String password, String nombre, String apellido) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public static ArrayList<User> objetoUsuarios(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        ArrayList<User> usuarios = new ArrayList<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            String correo = elemento[0];
            String contraseña = elemento[1];
            String nombre = elemento[2];
            String apellido = elemento[3];
            usuarios.add(new User(correo, contraseña, nombre, apellido));
        }
        
        return usuarios;
    }
    
    public static boolean verificar(String email, String password, ArrayList <User> lista){
        for (User u : lista) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
