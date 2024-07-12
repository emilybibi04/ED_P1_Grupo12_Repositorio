package Modelo;

public class Seccion {
    private static User logged;

    public static void setLogged(User user) {
        logged = user;
    }

    public static User getLogged() {
        return logged;
    }
    
}
