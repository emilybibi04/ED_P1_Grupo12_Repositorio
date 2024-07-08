package Modelo;

import java.io.IOException;
import java.util.ArrayList;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public static ArrayList<User> objetoUsuarios(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        ArrayList<User> usuarios = new ArrayList<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            String correo = elemento[0];
            String contraseña = elemento[1];
            usuarios.add(new User(correo, contraseña));
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
