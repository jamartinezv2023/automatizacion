package co.edu.udea.calidad.automatizacion.models;

public class User {
    private final String username;
    private final String password;
    private final String email;
    private final boolean agreeTerms;

    // Constructor para registro completo
    public User(String username, String password, String email, boolean agreeTerms) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.agreeTerms = agreeTerms;
    }

    // Constructor para login (solo username y password)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.email = "";         // valor por defecto
        this.agreeTerms = false; // valor por defecto
    }

    // Getters
    public String username() { return username; }
    public String password() { return password; }
    public String email() { return email; }
    public boolean agreeTerms() { return agreeTerms; }
}
