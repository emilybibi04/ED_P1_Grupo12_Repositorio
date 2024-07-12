package Modelo;

import com.espol.ed_p1_grupo12.App;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
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
    
    public static Set<User> objetoUsuarios(String nombrearchivo) throws IOException{
        
        Set<String> lineas = Readable.leerArchivo(nombrearchivo);
        Set<User> usuarios = new LinkedHashSet<>();

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
    
    public static final Comparator<User> emailComparator = Comparator.comparing(User::getEmail);
    public static final Comparator<User> passwordComparator = Comparator.comparing(User::getPassword);

    public static boolean verificar(String email, String password, Set<User> lista) {
        for (User u : lista) {
            if (emailComparator.compare(new User(email, "", "", ""), u) == 0 && passwordComparator.compare(new User("", password, "", ""), u) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean reconocerUsuarios(String correo, Set<User> usuarios) throws IOException {
        for (User usuario : usuarios) {
            if (compareStrings(correo, usuario.getEmail())) {
                return true;
            }
        }
        return false;
    }

    private static boolean compareStrings(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static User crearUsuario(String user, String pass, Set<User> lista) {
        User persona = null;
        for (User u : lista) {
            if (compareStrings(u.getEmail(), user) && compareStrings(u.getPassword(), pass)) {
                persona = new User(u.getEmail(), u.getPassword(), u.getNombre(), u.getApellido());
            }
        }
        return persona;
    }
    
    public static void actualizarArchivo(String in, String newEmail, String newPassword, String newNombre, String newApellido) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(App.pathArchivo + "usuarios.txt"));
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] partes = line.split(",");
            String correo = partes[0];
            if (compareStrings(correo, in)) {
                lines.set(i, newEmail + "," + newPassword + "," + newNombre + "," + newApellido);
                break;
            }
        }
        Files.write(Paths.get(App.pathArchivo + "usuarios.txt"), lines);
    }

}
