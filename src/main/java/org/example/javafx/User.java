package org.example.javafx;

public class User {
    private int id;
    private String nom;
    private String email;

    // Constructor
    public User(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
}
