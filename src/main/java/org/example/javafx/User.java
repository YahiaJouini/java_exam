package org.example.javafx;

public class User {
    private int id=0;
    private String nom;
    private String email;
    private String role;

    public User( String nom, String email,String role) {
        this.id +=1;
        this.nom = nom;
        this.email = email;
        this.role=role;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getRole(){
        return this.role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
