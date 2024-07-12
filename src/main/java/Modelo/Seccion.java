package Modelo;

public class Seccion {
    private static User logged;

    public static void setLoggedUser(User user) {
        logged = user;
    }

    public static User getLoggedUser() {
        return logged;
    }
}
